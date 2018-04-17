package com.clr;

import com.clr.utils.PathKit;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public class Test {
    public static void main(String[] args) {
        URLClassLoader classLoader= (URLClassLoader) Thread.currentThread().getContextClassLoader();
        URL[] urls= classLoader.getURLs();
        InputStream stream=classLoader.getResourceAsStream("web.xml");
        byte[] buffer=new byte[2048];
        Document document;
        try {
               document=new SAXReader().read(stream);
               Element element= document.getRootElement();
               Iterator<Element> iterator= element.elementIterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next().getName());
                }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
