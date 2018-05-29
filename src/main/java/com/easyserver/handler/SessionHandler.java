package com.easyserver.handler;

import com.easyserver.session.SessionManager;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class SessionHandler extends HandlerImpl {

    SessionManager sessionManager=new SessionManager();

    @Override
    public void doSart() {
        getSessionManager().start();
        super.doSart();
    }

    //getter and setter
    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
