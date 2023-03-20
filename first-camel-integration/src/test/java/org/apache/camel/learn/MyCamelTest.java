package org.apache.camel.learn;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class MyCamelTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from("direct:hola").to("log:foo");
            }
        };
    }

    @Test
    public void enviarHola() throws InterruptedException{
        template.sendBody("direct:hola", "Hola Mundo");
    }

    @Test
    public void enviarAdios() throws InterruptedException{
        template.sendBody("direct:hola", "Adios");
    }
    
}
