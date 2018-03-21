package com.clr.server;

import com.clr.connector.NioConnector;
import com.clr.context.WebAppContext;
import sun.management.ConnectorAddressLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class Server {

    //连接器
    List<NioConnector> connectors=new ArrayList<NioConnector>();

    //线程池
    ThreadPool threadPool=null;

    //connector

    //上下文
    WebAppContext context=new WebAppContext();


    //启动
    public void doStart(){
        setThreadPool(new ThreadPool());
    }

    //启动线程池
    private void setThreadPool(ThreadPool threaPool) {
        if (threadPool!=null){
            this.threadPool=threaPool;
        }
    }

    //getter and setter
    public WebAppContext getContext() {
        return context;
    }

    public void setContext(WebAppContext context) {
        this.context = context;
    }

    public void setNioConnector(NioConnector connector) {
        connectors.add(connector);
    }
}
