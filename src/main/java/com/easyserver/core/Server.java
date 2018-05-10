package com.easyserver.core;

import com.easyserver.connector.EasyConnector;
import com.easyserver.handler.Handler;
import com.easyserver.lifecycle.Lifecycle;
import com.easyserver.lifecycle.LifecycleImp;
import com.easyserver.thread.ThreadPool;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class Server extends LifecycleImp{

    EasyConnector easyConnector;

    ThreadPool threadPool;

    Handler handler;

    public Server() {
    }

    @Override
    public void doStart() {
        super.doStart();
        threadPool=new ThreadPool();
        handler.start();
    }

    //getter and setter
    public EasyConnector getEasyConnector() {
        return easyConnector;
    }

    public void setEasyConnector(EasyConnector easyConnector) {
        this.easyConnector = easyConnector;
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
