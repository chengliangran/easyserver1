package com.easyserver.connector;

import com.easyserver.lifecycle.Lifecycle;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class EasyConnector implements Lifecycle{

    int port;

    @Override
    public void start() {
        doSart();
    }

    @Override
    public void stop() {

    }

    @Override
    public void doSart() {

    }


    //setter and getter
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


}
