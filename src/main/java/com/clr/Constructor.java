package com.clr;


import com.clr.connector.NioConnector;
import com.clr.context.WebAppContext;
import com.clr.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class Constructor {



    public void start(String webAppDir,int port,String contextPath){

        Server server=new Server();
        //设置连接器
        NioConnector connector= new NioConnector();
        if(testPort(port)){
            connector.setPort(port);
        }else{
            System.out.println("警告:端口被占用");
        }
        //设置web容器
        WebAppContext context=new WebAppContext();
        context.setContextPath(contextPath);
        context.setWebAppFile(webAppDir);
        //组装server
        server.setContext(context);
        server.setNioConnector(connector);

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
        Matcher matcher=Pattern.compile("123").matcher("123123");
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        System.out.println(matcher.find());
        System.out.println();
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
