package com.clr.connector;

import com.clr.server.ThreadPool;
import com.sun.org.apache.bcel.internal.generic.ISHL;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public abstract class SelectManager {

    private int selectSets;

    private int maxIdleTime;

    SelectManager.SelectSet[] _selectSet;

    //存放channel
    private final ConcurrentLinkedQueue<Object> _changes=new ConcurrentLinkedQueue<Object>();

    ThreadPool threadPool;

    public void doStart(){
        //生成selector
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
                public void run() {
                    SelectSet selectSet = SelectManager.this._selectSet[finalI];
                    while (true){
                        selectSet.doSelect();
                    }
                }
            });
        }
    }

    public abstract void dispatch(Runnable runner);

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public void register(SocketChannel channel) {
        _selectSet[0].add(channel);
    }

    class SelectSet{

        Selector _selector;

        SelectSet() throws IOException {
            _selector=Selector.open();
        }

        public void doSelect(){
            final Selector selector;
            try {
                selector=Selector.open();

                int changesSize_changes=_changes.size();
                Object change;
                while (changesSize_changes-->0&&(change=_changes.poll())!=null){
                    if (change instanceof SocketChannel){
                        SelectionKey key = ((SocketChannel) change).register(selector, SelectionKey.OP_READ);
                        SocketChannelEndpoint endpoint=new SocketChannelEndpoint((SocketChannel) change);
                        key.attach(endpoint);
                        endpoint.schedule();
                    }
                }//注册selector

                int selected= selector.selectNow();//拿取所有准备好的socketchannel

                Set<SelectionKey> keys= selector.selectedKeys();
                for (SelectionKey key : keys) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        public void add(Object change){
            _changes.add(change);
            _selector.wakeup();
        }
        public void wakeup(){
            _selector.wakeup();
        }

    }

}
