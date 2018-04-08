package com.clr.context;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
public class WebAppClassLoader extends ClassLoader {

    ClassLoader classLoader;

    public WebAppClassLoader(ClassLoader contextClassLoader) {
        this.classLoader=contextClassLoader;
    }

}
