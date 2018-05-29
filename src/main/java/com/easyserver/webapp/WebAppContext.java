package com.easyserver.webapp;

import com.easyserver.common.Configurator;
import com.easyserver.configure.WebxmlProcessor;
import com.easyserver.handler.*;
import com.sun.xml.internal.ws.resources.ProviderApiMessages;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class WebAppContext extends HandlerImpl {

    String contextPath;

    String webAppDir;

    private String webInfDir;

    //配置器
    Configurator configurator=new Configurator();

    //xml解析
    WebxmlProcessor processor=new WebxmlProcessor();

    //classloader
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    //context-param
    HashMap<String,Object> contextParam=new HashMap<>();

    //handler链条
    SessionHandler sessionHandler=new SessionHandler();

    SecurityHandler securityHandler=new SecurityHandler();

    ServletHandler servletHandler=new ServletHandler();

    //servletcontext
    public static final ThreadLocal<ServletContext> sContext= new ThreadLocal<ServletContext>();

    ServletContext servletContext=new ServletContext();

    public WebAppContext(){
        contextParam.put("param","param");
    }
    @Override
    public void doSart() {
        configurator.configure(this);
        processor.process(this);

        setHandler(getSessionHandler());
        getSessionHandler().setHandler(getSecurityHandler());
        getSecurityHandler().setHandler(getServletHandler());
        sContext.set(servletContext);
        super.doSart();
    }

    //getter and setters
    public WebxmlProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(WebxmlProcessor processor) {
        this.processor = processor;
    }

    public SessionHandler getSessionHandler() {
        return sessionHandler;
    }

    public void setSessionHandler(SessionHandler sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    public SecurityHandler getSecurityHandler() {
        return securityHandler;
    }

    public void setSecurityHandler(SecurityHandler securityHandler) {
        this.securityHandler = securityHandler;
    }

    public ServletHandler getServletHandler() {
        return servletHandler;
    }

    public void setServletHandler(ServletHandler servletHandler) {
        this.servletHandler = servletHandler;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getWebAppDir() {
        return webAppDir;
    }

    public void setWebAppDir(String webAppDir) {
        this.webAppDir = webAppDir;
    }


    public void setWebInfDir(String webInfDir) {
        this.webInfDir = webInfDir;
    }

    public String getWebInfDir() {
        return webInfDir;
    }

    public Configurator getConfigurator() {
        return configurator;
    }

    public void setConfigurator(Configurator configurator) {
        this.configurator = configurator;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public static ServletContext getSContext(){
        return sContext.get();
    }

    public class ServletContext{

    }
}
