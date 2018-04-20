package com.clr.context;


import com.clr.context.ltmanager.DescriptorProcessor;
import com.clr.context.ltmanager.StandardDescriptorProcessor;
import com.clr.utils.Descriptor;

/**
 * Created by Administrator on 2018/3/21 0021.
 */
public class MetaData {

    DescriptorProcessor processor=new StandardDescriptorProcessor();

    public void resolve(WebAppContext webAppContext) {
        String defaultXml=  webAppContext.getDefaultXml();
        Descriptor defXmlDescriptor=new Descriptor(defaultXml);
        processor.process(webAppContext,defXmlDescriptor);

    }
}
