package com.clr.context;

import com.clr.configuration.ContextConfiguration;
import com.clr.context.handler.SecurityHandler;
import com.clr.context.handler.ServletHandler;
import com.clr.context.handler.SessionHandler;
import com.clr.lifecycle.Lifecycle;
import com.clr.utils.PathKit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class WebAppContext implements Lifecycle {

    String _contextPath;

    String _webAppDir;

    //配置类
    ContextConfiguration contextConfiguration=new ContextConfiguration();

    //加载器
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    //配置文档
    private String webXml="web.xml";

    //配置器
    private MetaData metadata=new MetaData();

    //本地编码信息
    private Map<String,String> localEncodingMap=new HashMap<>();

    //欢迎网页
    private String[] welcomeFiles;

    private SessionHandler sessionHandler =new SessionHandler();

    private SecurityHandler securityHandler =new SecurityHandler();

    private ServletHandler servletHandler =new ServletHandler();

    //interface  --lifecycle
    public void start() {
        contextConfiguration.configure(this);
        metadata.resolve(this);

    }

    public void stop() {

    }

    // getter and setter
    public String getContextPath() {
        return _contextPath;
    }

    public void setContextPath(String _contextPath) {
        this._contextPath = _contextPath;
    }

    public String getWebAppDir() {
        return _webAppDir;
    }

    public void setWebAppDir(String _webAppDir) {
        this._webAppDir = _webAppDir;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public String getWebXml() {
        return webXml;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public SessionHandler getSessionHandler() {
        return sessionHandler;
    }

    public SecurityHandler getSecurityHandler() {
        return securityHandler;
    }

    public ServletHandler getServletHandler() {
        return servletHandler;
    }

    public String[] getWelcomeFiles() {
        return welcomeFiles;
    }

    public void addWelcomeFile(String welcomeFile) {
        String[] oldWelcomeFiles=new String[welcomeFile.length()+1];
        oldWelcomeFiles[welcomeFile.length()]=welcomeFile;
        for (int i = 0; i < oldWelcomeFiles.length-1; i++) {
            oldWelcomeFiles[i]=welcomeFiles[i];
        }
        welcomeFiles=oldWelcomeFiles;
    }

    public Map<String, String> getLocalEncodingMap() {
        return localEncodingMap;
    }

    public void addLocalEncodingMap(String locale,String encoding) {
        localEncodingMap.put(locale,encoding);
    }

    //main
    public static void main(String[] args) {
        WebAppContext context=new WebAppContext();
        context.setContextPath("/");
        context.setWebAppDir(PathKit.webContent);
        context.start();
        System.out.println(PathKit.webContent);
    }
}
