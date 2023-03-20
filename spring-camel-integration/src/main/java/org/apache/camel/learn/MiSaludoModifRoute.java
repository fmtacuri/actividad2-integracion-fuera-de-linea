package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MiSaludoModifRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:saludomod")
            .log("primer body ${body}")
            .transform()
            .method("MiBean", "aMayusculas")
            .log("segundo body ${body}")
            .end()
            .to("stream:out");
    }

}
