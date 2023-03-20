package org.apache.camel.learn.processor;

import java.util.ArrayList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.learn.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonProcessor implements Processor {

  private final Logger log = LoggerFactory.getLogger(PersonProcessor.class);

  @Override
  public void process(Exchange exchange) {
    try {
      ArrayList<Person> list = (ArrayList) exchange.getIn().getBody();
      for (Person p : list) {
        log.info("Persona con cedula {} cuyos nombres {}", p.getCedula(), p.getNombres());
      }
    } catch (Exception exception) {
      log.error("Error in processor: PersonProcessor, with message: {}", exception.getMessage());
    }
  }
}
