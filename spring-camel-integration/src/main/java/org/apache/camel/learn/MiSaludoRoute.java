package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MiSaludoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:saludo").log("${body}").to("stream:out");
    }
    
}
