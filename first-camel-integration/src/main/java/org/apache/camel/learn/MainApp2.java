package org.apache.camel.learn;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultRegistry;

public class MainApp2 {

    public static void main(String... args) throws Exception {

        DefaultRegistry registry = new DefaultRegistry();
        registry.bind("myBeanMaskDNI", new MaskDNI());
        CamelContext context = new DefaultCamelContext(registry);
        context.addRoutes(new MyPipeline());
        context.start();
        Thread.sleep(5000);
        context.stop();
    }
    
}
