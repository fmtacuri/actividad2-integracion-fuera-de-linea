package org.apache.camel.learn;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class SaludosTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SaludosRouter();
    }

    @Test
    public void testSaludos() throws InterruptedException{
        System.out.println("Envio mensaje 1 por canal directo");
        template.sendBody("direct:inicio", "Hola");
        System.out.println("Envio mensaje 2 por canal directo");
        template.sendBody("direct:inicio", "Adios");
    }
    
}
