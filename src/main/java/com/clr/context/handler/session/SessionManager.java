package com.clr.context.handler.session;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class SessionManager {

    int seconds;//最大间隔时间


    //getter and setter
    public int getIntervalSeconds() {
        return seconds;
    }

    public void setIntervalSeconds(int seconds) {
        this.seconds = seconds;
    }
}
