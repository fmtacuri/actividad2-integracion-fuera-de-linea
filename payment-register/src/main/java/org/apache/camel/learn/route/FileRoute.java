package org.apache.camel.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.learn.processor.FacturaProcessor;

public class FileRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("sftp:localhost:2222/upload?noop=true&username=foo&password=pass&delete=true")
        .to("file:src/backup");

    from(
        "stream:file?fileName=src/backup/cardsclients.csv&scanStream=true&scanStreamDelay=1000&retry=true&fileWatcher=true")
        .process(new FacturaProcessor())
        .to("log:foo");
  }

}
