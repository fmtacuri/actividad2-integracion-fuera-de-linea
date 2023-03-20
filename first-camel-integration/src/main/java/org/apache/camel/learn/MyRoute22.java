package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class MyRoute22 extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:src/txt2?noop=true")
            .log("Intercepto ${body}")
            .to("mock:test")
            .log("Intercepto ${id}")
            .to("mock:test2")
            .log("Intercepto ${headers}")
            .to("file:target/txt");
    }
    
}
