package com.clr.lifecycle;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public interface Lifecycle {

    public static final String STATING="STATING";
    public static final String STATED="STATED";
    public static final String STOPPED="STOPPED";
    public static final String STOPPING="STOPPING";
    public static final String RUNNING="RUNNING";
    public static final String FAILED="FAILED";

    public static final int __FAILED=-1;
    public static final int __STOPPED=0;
    public static final int __STARTING=1;
    public static final int __STARTED=2;
    public static final int __STOPPING=3;

    public static final int _state=__STOPPED;

    public void start();

    public void stop();

}
