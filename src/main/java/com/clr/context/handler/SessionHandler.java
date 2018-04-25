package com.clr.context.handler;

import com.clr.context.WebAppContext;
import com.clr.context.handler.session.SessionManager;
import com.clr.context.handler.session.SessonIdManager;
import com.clr.utils.HttpRequest;
import com.clr.utils.HttpResponse;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class SessionHandler extends Handler{

    SessionManager sessionManager=new SessionManager();

    WebAppContext context;

    ClassLoader classLoader;

    SessonIdManager sessonIdManager=new SessonIdManager();
    //override
    @Override
    public void handle(HttpRequest request, HttpResponse response) {

        super.handle(request, response);
    }

    @Override
    public void start() {
        context=WebAppContext.getContext();
        if (context!=null){
            classLoader=context.getClassLoader();
        }
        sessionManager.start();
         super.start();
    }
    @Override
    public void stop() {
        super.stop();
    }

    //getter and setter
    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
