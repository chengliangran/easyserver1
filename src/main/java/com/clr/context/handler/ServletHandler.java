package com.clr.context.handler;

import com.clr.context.filter.Filter;
import com.clr.context.servlet.SerletHolder;
import com.clr.utils.HttpRequest;
import com.clr.utils.HttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class ServletHandler extends Handler{

    //servl 容器
    Map<String,SerletHolder> holderMap=new HashMap<>();

    //path 容器
    Map<String,String[]> pathMap=new HashMap<>();

    //filter
    List<Filter> filters=new ArrayList<>();

    //override

    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        super.handle(request, response);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    //getter and setter
    public SerletHolder getHolder(String servletName) {
        return holderMap.get(servletName);
    }

    public void setHolder(String servletName,SerletHolder holder){
        holderMap.put(servletName,holder);
    }

    public void setPath(String name,String[] paths){
        pathMap.put(name,paths);
    }

    public String[] getPaths(String name){
       return pathMap.get(name);
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void addFilters(Filter filter) {
        filters.add(filter);
    }
}
