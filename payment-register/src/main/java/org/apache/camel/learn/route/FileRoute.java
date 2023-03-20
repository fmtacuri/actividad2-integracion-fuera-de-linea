package org.apache.camel.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.learn.domain.Person;
import org.apache.camel.learn.processor.PersonProcessor;
import org.apache.camel.spi.DataFormat;

public class FileRoute extends RouteBuilder {

    DataFormat bindy = new BindyCsvDataFormat(Person.class);

    @Override
    public void configure() throws Exception {
        from("sftp:localhost:2222/upload?noop=true&username=foo&password=pass&delete=true")
            .to("file:src/backup/?fileName=${date:now:yyyyMMdd-HHmmss}-personas")
        .unmarshal(bindy)
        .process(new PersonProcessor())
        .to("log:foo");
    }
    
}
