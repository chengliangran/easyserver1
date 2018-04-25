package com.clr.context.handler.session;

import com.clr.lifecycle.Lifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class SessionManager implements Lifecycle{

    int seconds;//最大间隔时间

    boolean timeStop=true;

    Timer timer=new Timer();

    int scavengedPeriodMs=30000;

    TimerTask timerTask;

    List<Session> sessions=new ArrayList<>();

    @Override
    public void start() {
        timerTask=new TimerTask() {
            @Override
            public void run() {
                scavenge();
            }
        };
        timer.schedule(timerTask,scavengedPeriodMs);
    }

    @Override
    public void stop() {

    }

    public void scavenge(){

    }
    //getter and setter
    public int getIntervalSeconds() {
        return seconds;
    }

    public void setIntervalSeconds(int seconds) {
        this.seconds = seconds;
    }


}
