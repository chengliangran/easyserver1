package com.clr.context;

import com.clr.context.ltmanager.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
public class LtManager {
    //state
    boolean allwoDupFragments=true;

    boolean metaDataComplete;

    Map<String,OriginInfo> origins=new HashMap<String, OriginInfo>();

    WebDescriptor _webRoot;//两个网页-自定义web

    WebDescriptor _webDftRoot;// 默认web

    List<FragmentProcessor> _webFragmentsRoot=new ArrayList<FragmentProcessor>();

    Map<String,FragmentProcessor> _webFragmentNameMap=new HashMap<String, FragmentProcessor>();

    Map<Resouce,FragmentProcessor> _webFragmentResMap=new HashMap<Resouce, FragmentProcessor>();

    Map<Resouce,List<DiscoveredAnnotation>> _webFragmentAnnotation =new HashMap<Resouce, List<DiscoveredAnnotation>>();

    List<Resouce> webInfJars=new ArrayList<Resouce>();




    public void resolve() {
        origins.clear();
    }

    public static void main(String[] args) {
        System.out.println(MetaDataComplete.NotSet);
    }

}
