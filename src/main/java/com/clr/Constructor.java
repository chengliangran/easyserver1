package com.clr;


import com.clr.connector.NioConnector;
import com.clr.context.WebAppContext;
import com.clr.server.Server;

import java.io.IOException;
import java.net.ServerSocket;

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

    }

}
