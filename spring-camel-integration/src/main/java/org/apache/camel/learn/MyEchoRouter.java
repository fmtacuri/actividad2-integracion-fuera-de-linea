package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


public class MyEchoRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().host("localhost").port(8080);


        from("timer:echo?period=1000")
        .to("rest:get:echo/prueba")
        .log("${body}");
    }
    
}
