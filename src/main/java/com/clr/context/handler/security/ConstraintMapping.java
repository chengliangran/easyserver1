package com.clr.context.handler.security;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class ConstraintMapping {

    String method;

    String[] methodOmissions;

    String pathSpec;

    Constraint constraint;

    //getter and setter
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getMethodOmissions() {
        return methodOmissions;
    }

    public void setMethodOmissions(String[] methodOmissions) {
        this.methodOmissions = methodOmissions;
    }

    public String getPathSpec() {
        return pathSpec;
    }

    public void setPathSpec(String pathSpec) {
        this.pathSpec = pathSpec;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }
}
