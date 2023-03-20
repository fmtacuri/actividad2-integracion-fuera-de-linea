package org.apache.camel.learn;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class Saludos2Test extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SaludosMock();
    }

    @Test
    public void testSaludos2() throws InterruptedException{

        template.sendBody("direct:saludos", "Hola");

        MockEndpoint mock = getMockEndpoint("mock:resultados");
        mock.expectedMessageCount(1);
        mock.assertIsSatisfied();

    }
    
}
