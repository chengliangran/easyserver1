package com.easyserver.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class XmlKit {

    Element root;

    public XmlKit(String xmlPath){
        try {
            Document document =new SAXReader().read(new File(xmlPath));
            if (document!=null){
                root=document.getRootElement();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Element getRoot() {
        return root;
    }
}
