package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class MyRoute2 extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:src/txt?noop=true")
            .process(new MyProcessor())
            .to("file:target/txt");
    }
    
}
