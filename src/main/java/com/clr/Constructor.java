package com.clr;


import com.clr.connector.NioConnector;
import com.clr.context.WebAppContext;
import com.clr.lifecycle.Lifecycle;
import com.clr.server.Server;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class Constructor implements Lifecycle {

    private String webAppDir;

    private int port;

    private String contextPath;

    public void startConstruct(String webAppDir,int port,String contextPath){
        this.webAppDir=webAppDir;
        this.port=port;
        this.contextPath=contextPath;
        start();

    }

    private boolean testPort(int port) {//测试端口是否被占用
        try {
            new ServerSocket(port);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
                return false;
        }
    }

    public static void main(String[] args) {
//        Method method=new
    }
    private static void change(int change){
        switch (change){
            case 1:{
                System.out.println("case1");
                break;
            }
            case 2:
            case 3:{
                System.out.println("case3");
                break;
            }

        }

    }
   public void start() {
        Server server=new Server();

        NioConnector connector= new NioConnector();
        if(testPort(port)){
            connector.set_port(port);
        }else{
            System.out.println("警告:端口被占用");
        }

        WebAppContext context=new WebAppContext();
        context.setContextPath(contextPath);
        context.setWebAppFile(webAppDir);

        //组装server
        server.setContext(context);
        server.setNioConnector(connector);
        server.start();
    }

    public void stop() {

    }
}
class addInteger implements Runnable{

    private static Object lock=new Object();

    public static AtomicInteger count=new AtomicInteger(0);

    public void run() {
        int i=0;
        while (i<10000){
            count.getAndAdd(1);
            System.out.println(count);
            i++;
        }
    }
}
