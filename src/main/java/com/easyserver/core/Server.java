package com.easyserver.core;

import com.easyserver.connector.EasyConnector;
import com.easyserver.handler.Handler;
import com.easyserver.lifecycle.LifeCycleImpl;
import com.easyserver.multthread.ThreadPool;

import java.sql.Connection;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class Server extends LifeCycleImpl {

    EasyConnector connector;

    ThreadPool threadPool;

    Handler handler;
    
    Object lock=new Object();

    @Override
    public void start() {
        threadPool=new ThreadPool();

        handler.start();
        threadPool.start();
        connector.start();
        
    }



    //getter and setter
    public EasyConnector getConnector() {
        return connector;
    }

    public void setConnector(EasyConnector connector) {
        this.connector = connector;
    }

    public ThreadPool getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
