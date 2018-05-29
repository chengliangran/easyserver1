package com.easyserver.handler;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class HandlerImpl implements Handler {

    Handler handler;

    @Override
    public void start() {
        doSart();
    }

    @Override
    public void stop() {

    }

    @Override
    public void doSart() {
        if (getHandler()!=null){
        handler.start();
        }
    }

    @Override
    public void handle() {
    }

    @Override
    public void setHandler(Handler handler) {

    }

    @Override
    public Handler getHandler() {
        return null;
    }
}
