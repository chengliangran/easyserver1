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

    public void start() {//
        open();//设置serversockchannel

        selectManager.doStart();

        threadPool.dispath(new Acceptor());
    }

    public void stop() {

    }

     private void open() {
        try {
            serverSocketChannel=ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(true);

            serverSocketChannel.socket().bind(new InetSocketAddress(9090));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accept(){//多线程调用
        try {
            SocketChannel channel= serverSocketChannel.accept();
            
            channel.configureBlocking(false);
            
            Socket socket= channel.socket();

            selectManager.register(channel);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void configure(Socket socket) {
        System.out.println("配置socket内容");
    }

    public static void main(String[] args) {
        new NioConnector().start();
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

    class Acceptor implements Runnable{//多线程开关

        public void run() {
            while (true){
                accept();
            }
        }
    }
}
