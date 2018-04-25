package com.clr.context.handler;

import com.clr.lifecycle.Lifecycle;
import com.clr.utils.HttpRequest;
import com.clr.utils.HttpResponse;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class Handler implements Lifecycle{

    Handler handler;

    public void handle(HttpRequest request, HttpResponse response){

    }

    @Override
    public void start() {
        if (handler!=null){
            handler.start();
        }
    }

    @Override
    public void stop() {

    }

    //getter and setter
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }


}
