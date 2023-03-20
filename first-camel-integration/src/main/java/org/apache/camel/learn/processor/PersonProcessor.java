package org.apache.camel.learn.processor;

import java.util.ArrayList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.learn.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonProcessor implements Processor {

    private Logger log = LoggerFactory.getLogger(PersonProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        ArrayList<Person> list = (ArrayList) exchange.getIn().getBody();
        for (Person p : list){
            log.info("Persona con cedula {} cuyos nombres {}",p.getCedula(), p.getNombres());
        }
    }
    
}
