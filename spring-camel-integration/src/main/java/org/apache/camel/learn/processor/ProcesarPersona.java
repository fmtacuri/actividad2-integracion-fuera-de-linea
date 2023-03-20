package org.apache.camel.learn.processor;

import java.util.ArrayList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.learn.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcesarPersona implements Processor {

  private final Logger log = LoggerFactory.getLogger(ProcesarPersona.class);

  @Override
  public void process(Exchange exchange) throws Exception {
    ArrayList<Persona> list = (ArrayList) exchange.getIn().getBody();
    for (Persona p : list) {
      log.info("Persona con cedula {} cuyos nombres {}", p.getCedula(), p.getNombres());
    }
  }

}
