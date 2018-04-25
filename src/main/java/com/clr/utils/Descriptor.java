package com.clr.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.omg.CORBA.StringHolder;

import java.io.InputStream;

/**
 * Created by Administrator on 2018/4/17 0017.
 */

public class Descriptor {

    Document webXml;

    public Descriptor(String xmlStr){
        InputStream inputStream= Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlStr);
        try {
            webXml= new SAXReader().read(inputStream);
            System.out.println(webXml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Element getRootEle(){
        return webXml.getRootElement();
    }
}
