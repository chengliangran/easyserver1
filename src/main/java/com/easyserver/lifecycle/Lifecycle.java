package com.easyserver.lifecycle;

import javax.xml.stream.events.StartDocument;
import java.security.spec.PSSParameterSpec;

/**
 * Created by Administrator on 2018/5/9 0009.
 */
public interface Lifecycle {

    public static final String STOPPED="STOPPED";

    public static final String STARTING="STARTING";

    public static final String STARTED="STARTED";

    public void start();

    public void stop();

    public void doStart();

    public void doStop();
}
