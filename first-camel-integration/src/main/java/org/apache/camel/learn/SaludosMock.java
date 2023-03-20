package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class SaludosMock extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:saludos").id("saludosRoute2").to("mock:resultados");
    }
    
}
