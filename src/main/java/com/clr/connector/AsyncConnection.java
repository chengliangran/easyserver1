package com.clr.connector;

import com.clr.connector.http.HTTPGet;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class AsyncConnection {
    int time=0;

    SocketChannel channel;

    SocketChannelEndpoint endpoint;

    public AsyncConnection(SocketChannel channel, SocketChannelEndpoint endpoint) {

        this.channel = channel;
        this.endpoint = endpoint;
    }

    public void handle() {
        if (time==0){
            System.out.println("开启多线程处理socket");
            time=1;

        }else{

        }
    }
}
