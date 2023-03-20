package org.apache.camel.learn.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonProcessor implements Processor {

  private final Logger log = LoggerFactory.getLogger(PersonProcessor.class);

  @Override
  public void process(Exchange exchange) {
    try {
      log.info("Body: {}", exchange.getIn().getBody());
    } catch (Exception exception) {
      log.error("Error in processor: PersonProcessor, with message: {}", exception.getMessage());
    }
  }
}
