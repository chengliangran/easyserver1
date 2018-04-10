package com.clr.connector;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class SocketChannelEndpoint {
    SocketChannel channel;

    SelectManager.SelectSet set;

    SelectionKey key;

    AsyncConnection connection;

    SocketChannelEndpoint(SocketChannel channel, SelectManager.SelectSet set,SelectionKey key) {
        this.channel=channel;
        this.set=set;
        this.key=key;

    }

    public SocketChannelEndpoint(SocketChannel change, SelectionKey key) {

    }

    public void schedule() {//多线程开关
        SelectManager manager= set.getManager();
        manager.dispatch(new Runnable() {
            public void run() {
                handle();
            }
        });
    }

    public void handle(){//多线程调用
        while (true)
        {
            connection.handle();
        }
    }

    //getter and setter
    public void setConnection(AsyncConnection connection) {
        this.connection=connection;
    }
}
