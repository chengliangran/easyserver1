package com.clr.configuration;

import com.clr.context.WebAppContext;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Administrator on 2018/4/17 0017.
 */

public class ContextConfiguration {

    WebAppContext context;

    //配置context环境  主要要的一个是webapp（包括重要的webinf） 另一个是临时文件夹
    public void preConfigure(){
        if (context!=null){
            //配置临时文件夹（为什么需要这个暂时我也不清楚）
            //如果webapp是jar的话先解压jar包
            //验证所有jar的内容
            URLClassLoader classLoader= (URLClassLoader)context.getClassLoader();
            URL[] urls=classLoader.getURLs();
            for (int i = 0; i < urls.length; i++) {
                URL url = urls[i];
                System.out.println(url);
            }
            //拿到默认的xml描述文件和 自定义的xml描述文件
             //搜索webinfjars 和metainf的信息
            //找到web-fragment的xml 相当于子jar包的xml
        }
    };

    public void configure(WebAppContext context) {
        //取出webinf里面的 classes和lib 里面的图纸将其塞入classloader之中
    }

    public void postConfigure() {

    }

    //getter and setter
    public WebAppContext getContext() {
        return context;
    }

    public void setContext(WebAppContext context) {
        this.context = context;
    }


}
