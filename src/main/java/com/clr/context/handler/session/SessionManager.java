package com.clr.context.handler.session;

import com.clr.lifecycle.Lifecycle;
import com.clr.utils.PathKit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class SessionManager implements Lifecycle{

    int idileSeconds;//最大间隔时间

    boolean timeStop=true;

    Timer timer=new Timer();

    int scavengedPeriodMs=30000;

    TimerTask timerTask;

    List<Session> sessions=new ArrayList<>();

    String storeDir= System.getProperty("user.dir")+"/../../sessionDir";//sessionc存储地

    @Override
    public void start() {
        File file=new File(storeDir);
        if (file.exists()){
            FileKit.
        }else {
            file.mkdir();
        }
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
        List<Session> sessions=this.sessions;
        for (int i = 0; i < sessions.size(); i++) {
            long now =System.currentTimeMillis();
            if (sessions.get(i).getAccessed()*1000l+idileSeconds*1000l<now){
                sessions.get(i).expired(true);
                sessions.remove(i);
            }
        }
    }
    //getter and setter
    public int getIntervalSeconds() {
        return idileSeconds;
    }

    public void setIntervalSeconds(int seconds) {
        this.idileSeconds = seconds;
    }


}
