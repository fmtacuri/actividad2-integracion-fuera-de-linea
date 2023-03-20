package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;

public class MyRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:iniciaSaludo")
        .log("Mensaje de entrada ${body}")
        .choice()
        .when().simple("${body} contains 'Mundo'")
            .log("El saludo si contiene el patron")
        .otherwise()
            .log("Mensaje no cumple condicion")
        .end()
        .to("direct:finalizaSaludo");

        from("direct:finalizaSaludo").to("log:foo");
    }
    
}
