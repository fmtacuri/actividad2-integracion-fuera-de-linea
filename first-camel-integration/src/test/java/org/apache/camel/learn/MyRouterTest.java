package org.apache.camel.learn;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class MyRouterTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MyRouter();
    }

    @Test
    public void testRouter(){
        template.sendBody("direct:iniciaSaludo", "Hola");

        template.sendBody("direct:iniciaSaludo", "Hola Mundo");
    }
    
}
