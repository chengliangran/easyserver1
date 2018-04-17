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
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

    String xmlStr;

    public Descriptor(String xmlStr){
        this.xmlStr=xmlStr;
    }

    public Element getRootEle(){
        Element element=null;
        InputStream inputStream= classLoader.getResourceAsStream(xmlStr);
        try {
            element= new SAXReader().read(inputStream).getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return element;
    }


    //getter and setter
    public String getXmlStr() {
        return xmlStr;
    }

    public void setXmlStr(String xmlStr) {
        this.xmlStr = xmlStr;
    }
}
