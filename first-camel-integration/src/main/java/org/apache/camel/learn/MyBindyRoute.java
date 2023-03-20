package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class MyBindyRoute extends RouteBuilder {

    DataFormat bindy = new BindyCsvDataFormat(org.apache.camel.learn.Persona.class);

    @Override
    public void configure() throws Exception {
        from("sftp:localhost:2222/upload?noop=true&username=foo&password=pass&delete=true")
            .to("file:src/backup/?fileName=${date:now:yyyyMMdd-HHmmss}-personas")
        .unmarshal(bindy)
        .process(new ProcesarPersona())
        .to("log:foo");
    }
    
}
