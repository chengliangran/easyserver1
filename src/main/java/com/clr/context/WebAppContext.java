package com.clr.context;

import com.clr.lifecycle.Lifecycle;
import com.sun.xml.internal.ws.api.model.ParameterBinding;
import com.sun.xml.internal.ws.api.wsdl.parser.MetaDataResolver;
import com.sun.xml.internal.ws.org.objectweb.asm.FieldVisitor;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public class WebAppContext implements Lifecycle {

    String contextPath;//路径地址

    MetaData _metadata=new MetaData();

    ClassLoader loader=Thread.currentThread().getContextClassLoader();

    File webAppFile;//webapp 的地址

    File webInfFile;//webinf 的地址

    File tempFile;//临时文件的 的地址 下面的是判断是否存在
    boolean tempFileConfigured;

    String _preUnpackBaseResourcePath;//这是war包的地址

    String[] _dftConfigurationClasses={
        "com.clr.context.configurations.DefaultConfiguration",
    };//webapp配置器

    String[] configurationClasses;//配置器的类名

    Configuration[] configurations;//配置器
    private boolean _available;
    private ClassLoader _loader;
    private Object _context=new Object();
    private Object __context;
    private LtManager _ltManager;

    public void doStart(){
        loadConfiguration();

    }

    private void loadConfiguration() {
        try {
            if (configurations==null){
                configurationClasses=_dftConfigurationClasses;
                configurations=new Configuration[configurationClasses.length];
                for (int i=0;i<configurations.length;i++) {
                    configurations[i]=(Configuration) loader.loadClass(configurationClasses[i]).newInstance();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        _loader=new WebAppClassLoader(Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(_loader);

        __context=_context;

        _ltManager.resolve();
        System.out.println("启动context");
    }

    public void stop() {

    }

    //getter and setter
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public File getWebApp() {
        return webAppFile;
    }

    public void setWebAppFile(String webAppPath) {
        webAppFile=new File(System.getProperty("user.dir")+File.separator+webAppPath);
    }

    public static void main(String[] args) {
        System.out.println(new File(System.getProperty("user.dir")+"/../../../../../..").exists());
   }


}
