package com.clr.context.handler.session;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class Session {

    long accessed=0;

    boolean expired=false;

    //expired
    public void expired(boolean expired){
        this.expired=expired;
    }

    //getter and setter
    public long getAccessed() {
        return accessed;
    }

    public void setAccessed(long accessed) {
        this.accessed = accessed;
    }
}
