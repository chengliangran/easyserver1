package com.clr.context.ltmanager;

import com.clr.context.WebAppContext;
import com.clr.context.WebDescriptor;
import com.clr.utils.Descriptor;
import org.dom4j.Element;

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
            tag_methods.put("listener",this.getClass().getDeclaredMethod(""));
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
            Method method=

        }
    }
}
