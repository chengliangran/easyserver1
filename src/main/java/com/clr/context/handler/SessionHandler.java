package com.clr.context.handler;

import com.clr.context.handler.session.SessionManager;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class SessionHandler {

    SessionManager sessionManager=new SessionManager();

    //getter and setter
    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
