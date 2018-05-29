package com.easyserver.session;

import com.easyserver.lifecycle.Lifecycle;
import com.easyserver.webapp.WebAppContext;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class SessionManager implements Lifecycle {

    int sessionTimeout;

    SessionIdManager sessionIdManager=new SessionIdManager();

    @Override
    public void start() {
         WebAppContext.ServletContext servletContext= WebAppContext.getSContext();
          System.out.println();

    }

    @Override
    public void stop() {

    }

    @Override
    public void doSart() {

    }
    //getter and setter
    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }


}
