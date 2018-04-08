package com.clr.context.ltmanager;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
public class Resouce {
    String urlStr;
    URL url;
    URLConnection connection;
    InputStream is;

    public Resouce(URL url, URLConnection connection) {
        this.url = url;
        this.connection = connection;
    }

}
