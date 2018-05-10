package com.easyserver.handler;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class HandlerImp implements Handler {

    Handler handler;

    @Override
    public void handle() {
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {

    }

    @Override
    public void doStart() {
        if (handler!=null){
            handler.doStart();
        }
    }

    @Override
    public void doStop() {

    }

    @Override
    public Handler getHandler() {
        return handler;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
