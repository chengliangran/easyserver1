package com.clr.context;

import com.clr.configuration.ContextConfiguration;
import com.clr.lifecycle.Lifecycle;
import com.clr.utils.PathKit;
import com.sun.xml.internal.ws.api.model.ParameterBinding;
import com.sun.xml.internal.ws.api.wsdl.parser.MetaDataResolver;
import com.sun.xml.internal.ws.org.objectweb.asm.FieldVisitor;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class WebAppContext implements Lifecycle {

    String _contextPath;

    String _webAppDir;

    //配置类暂时先锁死
    ContextConfiguration contextConfiguration=new ContextConfiguration();

    //classloader 默认暂时先使用默认的thread提供的lorder
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    //默认的解释器
    private String defaultXml="defaultWeb.xml";

    //自定义的解释文档
    private String webXml="web.xml";

    //context装配类metadata负责初始化metadata
    private MetaData metadata;

    //interface  --lifecycle
    public void start() {
        //前配置
        contextConfiguration.setContext(this);
        contextConfiguration.preConfigure();
        //配置
        contextConfiguration.configure();
        metadata.resolve(this);



        //后配置
        contextConfiguration.postConfigure();
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

    public static void main(String[] args) {
        WebAppContext context=new WebAppContext();
        context.setContextPath("/");
        context.setWebAppDir(PathKit.webContent);
        context.start();
        System.out.println(PathKit.webContent);
    }

    public String getDefaultXml() {
        return defaultXml;
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
}
