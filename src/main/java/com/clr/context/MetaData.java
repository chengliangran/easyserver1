package com.clr.context;


import com.clr.context.ltmanager.DescriptorProcessor;
import com.clr.context.ltmanager.StandardDescriptorProcessor;
import com.clr.utils.Descriptor;
import org.dom4j.Document;

/**
 * Created by Administrator on 2018/3/21 0021.
 */
public class MetaData {

    String webXml="web.xml";

    Descriptor webDescriptor;

    StandardDescriptorProcessor processor=new StandardDescriptorProcessor();

    public void resolve(WebAppContext webAppContext) {
        String webXml=this.getWebXml();
        if (webDescriptor==null){
            webDescriptor=new Descriptor(webXml);
        }
        processor.process(webAppContext,webDescriptor);

    }

    //getter and setter

    public String getWebXml() {
        return webXml;
    }

    public void setWebXml(String webXml) {
        this.webXml = webXml;
    }

    public Descriptor getWebDescriptor() {
        return webDescriptor;
    }

    public void setWebDescriptor(Descriptor webDescriptor) {
        this.webDescriptor = webDescriptor;
    }

    public StandardDescriptorProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(StandardDescriptorProcessor processor) {
        this.processor = processor;
    }
}
