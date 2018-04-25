package com.clr.context.ltmanager;

import com.clr.context.WebAppContext;
import com.clr.context.WebDescriptor;
import com.clr.utils.Descriptor;
import org.dom4j.Element;
import org.dom4j.Node;

import javax.swing.text.html.HTML;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/17 0017.
 */

public class StandardDescriptorProcessor implements DescriptorProcessor {

    Map<String,Method> tag_methods=new HashMap<>();

    public StandardDescriptorProcessor() {
        try {
            tag_methods.put("listener",this.getClass().getDeclaredMethod("setListener",new Class[]{WebAppContext.class, org.dom4j.Node.class}));
            tag_methods.put("servlet",this.getClass().getDeclaredMethod("setServlet",new Class[]{WebAppContext.class, org.dom4j.Node.class}));
            tag_methods.put("security_constraint",this.getClass().getDeclaredMethod("setSecurityConstraint",new Class[]{WebAppContext.class, org.dom4j.Node.class}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    //阅读xml文件 填充web.xml
    public void process(WebAppContext webAppContext, Descriptor descriptor) {
        Element rootEle= descriptor.getRootEle();
        Iterator iterator=rootEle.elementIterator();
        while (iterator.hasNext()){
            Element element= (Element) iterator.next();
            String tag= element.getName();
            Method method=tag_methods.get(tag);
            System.out.println(method);
            //第三级结束
        }
    }

    //配置context
    public void setListener(WebAppContext context, Node node){

    }

    //设置安全限制
    public void setSecurityConstraint(WebAppContext context,Node node){

    }

    //设置servlet
    public void setServlet(WebAppContext context, Node node){

    }

}
