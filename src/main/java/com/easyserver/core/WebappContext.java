package com.easyserver.core;

import com.easyserver.configure.Configurator;
import com.easyserver.configure.DescriptorManager;
import com.easyserver.context.ServletContext;
import com.easyserver.handler.*;
import com.easyserver.util.MimeTypes;
import com.easyserver.util.WebClassLoader;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import javax.activation.MimeType;
import java.net.URL;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class WebappContext extends HandlerImp {

    private String contextPath;

    private String webapp;

    private String webContent;

    private String webinf;

    Server server;

    Configurator configurator=new Configurator();

    DescriptorManager descriptorManager;

    MimeTypes mimeType=new MimeTypes();

    Handler handler=null;

    ServletContext servletContext=new ServletContext();

    SessionHanler sessionHanler=new SessionHanler();

    SecurityHandler securityHandler = new SecurityHandler();

    ServletHandler servletHandler=new ServletHandler();

    public WebappContext(Server server){
        this.server=server;
    }

    @Override
    public void doStart() {
        super.doStop();
        configurator.configure(this);
        if (descriptorManager!=null){
            descriptorManager.digest();
        }

        //配置启动，handle链
        Handler handler1=null;
        handler1=getServletHandler();
        getSecurityHandler().setHandler(handler1);
        handler1=getSecurityHandler();
        getSessionHanler().setHandler(handler1);
        handler1=getSessionHanler();
        this.handler=getSessionHanler();
        super.doStart();
    }

    //getter and setter
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getWebapp() {
        return webapp;
    }

    public void setWebapp(String webapp) {
        this.webapp = webapp;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Configurator getConfigurator() {
        return configurator;
    }

    public void setConfigurator(Configurator configurator) {
        this.configurator = configurator;
    }

    public DescriptorManager getDescriptorManager() {
        return descriptorManager;
    }

    public void setDescriptorManager(DescriptorManager descriptorManager) {
        this.descriptorManager = descriptorManager;
    }

    public SessionHanler getSessionHanler() {
        return sessionHanler;
    }

    public void setSessionHanler(SessionHanler sessionHanler) {
        this.sessionHanler = sessionHanler;
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

    public String getWebContent() {
        return webContent;
    }

    public void setWebContent(String webContent) {
        this.webContent = webContent;
    }

    public MimeTypes getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeTypes mimeType) {
        this.mimeType = mimeType;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getWebinf() {
        return webinf;
    }

    public void setWebinf(String webinf) {
        this.webinf = webinf;
    }
}
