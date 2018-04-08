package com.clr.context.ltmanager;

import com.clr.context.WebAppContext;
import com.clr.context.WebDescriptor;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
public interface DescriptorProcessor  {
    public void process(WebAppContext webAppContext, WebDescriptor descriptor);


}
