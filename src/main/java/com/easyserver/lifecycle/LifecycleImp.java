package com.easyserver.lifecycle;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class LifecycleImp implements Lifecycle {

    public String status=STOPPED;

    @Override
    public void start(){
        if (isStopped()){
            setSTARTING();
            doStart();
            setSTARTED();
        }
    };

    @Override
    public void stop(){

    };

    public void doStart(){

    }

    public void doStop(){

    }

    public boolean isStopped(){
        return status==STOPPED;
    }

    public boolean isStarted(){
        return status==STARTED;
    }

    public boolean isStarting(){
        return status==STARTING;
    }

    public  void setSTOPPED() {
        this.status=STOPPED;
    }

    public  void setSTARTING() {
        this.status=STARTING;
    }

    public  void setSTARTED() {
        this.status=STARTED;
    }
}
