package com.easyserver.core;


import com.easyserver.connector.EasyConnector;
import com.easyserver.util.PathKit;
import com.easyserver.webapp.WebAppContext;
import sun.nio.ch.FileKey;

import java.io.File;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class ServerConstructor {

    String contextPath;

    String webAppDir;

    int port;

    Object lock=new Object();

    public ServerConstructor(String contextPath, String webAppDir, int port) {
        this.contextPath = contextPath;
        this.webAppDir = webAppDir;
        this.port = port;
    }

    public void construct(){
        Server server=new Server();

        EasyConnector connector=new EasyConnector();
        connector.setPort(port);

        WebAppContext webAppContext=new WebAppContext();
        webAppContext.setContextPath(contextPath);
        webAppContext.setWebAppDir(PathKit.getWebRoot()+File.separator+webAppDir);

        server.setHandler(webAppContext);
        server.setConnector(connector);

        server.start();

        join();

    }

    private void join() {
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ServerConstructor("/","src/main/webapp",8080).construct();
    }
}
