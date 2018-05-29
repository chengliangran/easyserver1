package com.easyserver.common;

import com.easyserver.webapp.WebAppContext;

import java.io.File;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class Configurator {

    public void configure(WebAppContext webAppContext) {
        String webappDir=webAppContext.getWebAppDir();
        String webInfDir=webappDir+File.separator+"WEB-INF";
        if (new File(webInfDir).exists()){
            webAppContext.setWebInfDir(webInfDir);
        }else{
            System.out.println("没有找到文件");
            return;
        }
        String webXml=webInfDir+ File.separator+"web.xml";
        if (new File(webXml).exists()){
            webAppContext.getProcessor().setWebXml(webXml);
        }else {
            System.out.println("没有找到文件");
            return;
        }
    }
}
