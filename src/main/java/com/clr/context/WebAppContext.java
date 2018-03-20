package com.clr.context;

import java.io.File;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class WebAppContext {

    String contextPath;//路径地址

    File webApp;//webapp 的地址

    String[] _dftConfigurationClasses={

    };//webapp配置器

    String[] configurationClasses;

    Configuration[] configurations;


    //getter and setter
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public File getWebApp() {
        return webApp;
    }

    public void setWebApp(String webAppPath) {
        webApp=new File(System.getProperty("user.dir")+File.separator+webAppPath);
    }

    public static void main(String[] args) {
        WebAppContext context=new WebAppContext();
        context.setWebApp("src/main/webapp");
        System.out.println(context.getWebApp().isDirectory());
    }
}
