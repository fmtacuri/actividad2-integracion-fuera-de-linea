package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class SaludosRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:inicio").id("saludosRouter1").to("log:foo");
    }
}
