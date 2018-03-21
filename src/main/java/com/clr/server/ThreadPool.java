package com.clr.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class ThreadPool {

    private final AtomicInteger currentThreads=new AtomicInteger();//当前线程数

    private final int maxThreads=100;//最大线程数

    private final int minThreads=10;//最低线程数

    private final ConcurrentLinkedQueue _threads=new ConcurrentLinkedQueue<Thread>();//线程内容

    private BlockingQueue _jobs;//线程需要处理的工作

    private Runnable runnable=new Runnable() {
        public void run() {
            System.out.println("processor");
        }
    };

    ThreadPool(){
        currentThreads.set(0);
        _jobs=new ArrayBlockingQueue<Runnable>(maxThreads);
        while (currentThreads.get()<minThreads){
            newThread();
        }
    }

    public void doStart(){
    }

    private boolean newThread() {
        currentThreads.set(currentThreads.get()+1);
        boolean started=false;
        try  {
            _threads.add(new Thread(runnable));
            started=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return started;
    }


}
