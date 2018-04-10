package com.clr.connector;

import com.clr.connector.http.HTTPGet;
import com.clr.server.ThreadPool;
import com.sun.org.apache.bcel.internal.generic.ISHL;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public abstract class SelectManager {

    private int selectSets;

    private int maxIdleTime;

    SelectManager.SelectSet[] _selectSet;

    //save channel
    private final ConcurrentLinkedQueue<Object> _changes=new ConcurrentLinkedQueue<Object>();

    private ConcurrentMap<SocketChannelEndpoint,Object> _endPoints=new ConcurrentHashMap<SocketChannelEndpoint,Object>();

    public void doStart(){
        //generate selector
        _selectSet=new SelectSet[2];
        for (int i = 0; i < _selectSet.length; i++) {
            try {
                _selectSet[i]=new SelectSet();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i=0;i<_selectSet.length;++i) {
            final int finalI = i;
            this.dispatch(new Runnable() {
                public void run() {//多线程开关
                    SelectSet selectSet = SelectManager.this._selectSet[finalI];
                    while (true){
                        selectSet.doSelect();
                    }
                }
            });
        }
    }

    public abstract void dispatch(Runnable runner);

    public void register(SocketChannel channel) {
        _selectSet[0].add(channel);
    }

    class SelectSet{//内部类

        Selector _selector;

        Selector selector;

        SelectSet() throws IOException {
            _selector=Selector.open();

            selector=Selector.open();
        }

        public void doSelect(){//多线程调用

            try {

                int changesSize_changes=_changes.size();
                Object change;
                while (changesSize_changes-->0&&(change=_changes.poll())!=null){
                    if (change instanceof SocketChannel){
                        SelectionKey key = ((SocketChannel) change).register(selector, SelectionKey.OP_READ);
                        SocketChannelEndpoint endpoint=newSocketChannelEndpoint((SocketChannel) change,this,key);
                        endpoint.setConnection(new AsyncConnection((SocketChannel) change,endpoint));
                        key.attach(endpoint);
//                        endpoint.schedule();
                    }
                }//register selector

                int selected= selector.selectNow();//get prepared socketchannel

                Set<SelectionKey> keys= selector.selectedKeys();
                for (SelectionKey key : keys) {
                    System.out.println(key.channel());
                    String msg= HTTPGet.finishResp();
                    ByteBuffer buffer= ByteBuffer.allocate(msg.getBytes().length);
                    buffer.put(msg.getBytes());
                    SocketChannel channel = null;
                    try {
                        channel= (SocketChannel) key.channel();
                        buffer.flip();
                        channel.write(buffer);
                        channel.finishConnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    key.cancel();
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private SocketChannelEndpoint newSocketChannelEndpoint(SocketChannel change,SelectSet set1, SelectionKey key) {
            SocketChannelEndpoint endpoint=createEndpoint((SocketChannel)change,set1,key);

            _endPoints.put(endpoint,this);
            return endpoint;
        }

        private SocketChannelEndpoint createEndpoint(SocketChannel change,SelectSet selectSet, SelectionKey key) {
            SocketChannelEndpoint endpoint=new SocketChannelEndpoint((SocketChannel) change,selectSet,key);
            return endpoint;
        }

        public void add(Object change){
            _changes.add(change);
            _selector.wakeup();
        }
        public void wakeup(){

            _selector.wakeup();
        }
        //getter and setter
        public SelectManager getManager(){
            return SelectManager.this;
        }

    }

}
