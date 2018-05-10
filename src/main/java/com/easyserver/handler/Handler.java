package com.easyserver.handler;

import com.easyserver.lifecycle.Lifecycle;

/**
 * Created by Administrator on 2018/5/9 0009.
 */
public interface Handler extends Lifecycle {

    public void handle();

    public void setHandler(Handler handler);

    public Handler getHandler();

}
