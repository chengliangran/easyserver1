package com.clr.context;

import com.clr.context.ltmanager.MetaDataComplete;
import com.clr.context.ltmanager.Resouce;
import com.clr.utils.XmlParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
public class WebDescriptor {

    public Resouce _xml;

    public static XmlParser _parser;

    public ArrayList<String> _classNames=new ArrayList<String>();

    public MetaDataComplete _metaDataComplete;

    private boolean _isOrdered=false;

    WebDescriptor(Resouce xml){
        this._xml=xml;
    }
}

