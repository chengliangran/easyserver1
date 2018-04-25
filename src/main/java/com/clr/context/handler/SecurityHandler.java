package com.clr.context.handler;

import com.clr.context.handler.security.ConstraintMapping;
import com.clr.utils.HttpRequest;
import com.clr.utils.HttpResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class SecurityHandler extends Handler{

    List<ConstraintMapping> constraintMappings=new ArrayList<>();

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
    public List<ConstraintMapping> getConstraintMappings() {
        return constraintMappings;
    }

    public void addConstraintMappings(ConstraintMapping mapping) {
        constraintMappings.add(mapping);
    }
}
