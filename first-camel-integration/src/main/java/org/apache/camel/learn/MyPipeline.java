package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class MyPipeline extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:src/datos?noop=true&fileName=persona.csv")
        .pipeline()
        
        .bean("myBeanMaskDNI","mask")

        /*
        .bean(new MyBean(),"saludo1")
        .to("log:foo")
        .log("Header ${headers}")
        */
        .log("Body ${body}")
        .to("mock:end");
    }

    
}
