package com.easyserver.configure;

import com.easyserver.util.XmlKit;
import com.easyserver.webapp.WebAppContext;
import org.dom4j.Element;
import org.dom4j.Node;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class WebxmlProcessor {

    String webXml;

    Map<String,Method> tagMethods=new HashMap<>();

    public WebxmlProcessor(){
        try {
            tagMethods.put("session-config",WebxmlProcessor.class.getDeclaredMethod("implSessionConfig", WebAppContext.class, Element.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void process(WebAppContext webAppContext) {
        System.out.println(getWebXml());
        Element root= new XmlKit(getWebXml()).getRoot();
        if (root==null){
            System.out.println("没有找到指定的xml文件");
            return;
        }
        List<Element> elements=root.elements();
        for (Element element : elements) {
            Method method=tagMethods.get(element.getName());
            if (method!=null){
                try {
                    method.invoke(this,new Object[]{webAppContext,element});
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //invoke方法
    public void implSessionConfig(WebAppContext webappContext, Element node){
        System.out.println("configure session-config");
        String sessionTimeout=node.element("session_timeout").getText();
        try {
            webappContext.getSessionHandler().getSessionManager().setSessionTimeout(Integer.parseInt(sessionTimeout));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("解析session错误");
        }
    }

    //getter and setter
    public void setWebXml(String webXml) {
        this.webXml = webXml;
    }

    public String getWebXml() {
        return webXml;
    }


}
