package com.clr.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class ThreadPool {

    BlockingQueue runners=new ArrayBlockingQueue(10);

    public void dispath(Runnable runner) {
        Thread thread=new Thread(runner);
        thread.start();

        runners.offer(runner);
    }
}
