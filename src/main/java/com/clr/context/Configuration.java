package com.clr.context;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
public interface Configuration {
    public void setContext(WebAppContext configuration);
    public WebAppContext getContext();
    public void preConfig();
    public void config();
    public void postConfig();
}
