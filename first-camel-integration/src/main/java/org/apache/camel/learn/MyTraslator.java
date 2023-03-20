package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class MyTraslator extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/datos?noop=True&fileName=grados.csv")
        .bean(new Grados(), "convertCenFa")
        .to("log:foo");
    }
    
}
