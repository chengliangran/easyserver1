package com.clr.connector;

import com.clr.lifecycle.Lifecycle;
import com.clr.server.ThreadPool;
import com.clr.utils.PathKit;
import com.sun.corba.se.pept.transport.Acceptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/20 0020.
 */

/*
* 配置* */
public class NioConnector implements Lifecycle {

    int _port;
    //1
    ServerSocketChannel serverSocketChannel;

    SelectManager selectManager=new DispatchSelectManager();

    //2
    ThreadPool threadPool=new ThreadPool();

    //初始化连接器
    public void start() {
        open();//设置serversockchannel

        threadPool=new ThreadPool();//设置threadpool

        selectManager.doStart();

        threadPool.dispath(new Acceptor());
    }

    public void stop() {

    }

    //设置serversocketchannel非阻塞生成socket
    private void open() {
        try {
            serverSocketChannel=ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(true);

            if (get_port()>0){
                serverSocketChannel.socket().bind(new InetSocketAddress(get_port()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accept(){
        try {
            SocketChannel channel= serverSocketChannel.accept();
            
            channel.configureBlocking(false);
            
            Socket socket= channel.socket();
            configure(socket);
            
            selectManager.register(channel);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void configure(Socket socket) {
        System.out.println("配置socket内容");
    }

    //getter and setter
    public int get_port() {
        return _port;
    }

    public void set_port(int _port) {
        this._port = _port;
    }

    class DispatchSelectManager extends SelectManager{

        public void dispatch(Runnable runner) {
            threadPool.dispath(runner);
        }
    }

    class Acceptor implements Runnable{

        public void run() {
            while (true){
                accept();
            }
        }
    }
}
