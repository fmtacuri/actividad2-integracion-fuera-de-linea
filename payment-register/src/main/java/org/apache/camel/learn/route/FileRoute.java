package org.apache.camel.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.learn.processor.DbProcessor;
import org.apache.camel.learn.processor.FacturaProcessor;

public class FileRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    //Obtener del servidor SFTP
    from("sftp:localhost:2222/upload?noop=true&username=foo&password=pass&delete=true").to(
        "file:src/backup");

    // Validar antes de guardar
    from(
        "stream:file?fileName=src/backup/cardsclients.csv&scanStream=true&scanStreamDelay=1000&retry=true&fileWatcher=true").process(
            new FacturaProcessor())
        .choice()
        .when(header("state").in("true"))
        .process(new DbProcessor())
        .otherwise()
        .log(
            "No se puede guardar el id de pago: ${header.id-parameter}, porque hay valores negativos")
        .end();
  }

}
