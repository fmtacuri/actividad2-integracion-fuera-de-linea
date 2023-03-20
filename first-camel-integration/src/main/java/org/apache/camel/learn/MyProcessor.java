package org.apache.camel.learn;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProcessor implements Processor{

    private Logger log = LoggerFactory.getLogger(MyProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Message msg = exchange.getIn();
        log.info("Consegui el mensaje");
        String body = msg.getBody(String.class);
        log.info("Message Body {}", body);
        msg.setBody(new String("Modificado"));
        msg.setHeader("TokenSecurity", "adsjfiupeorñlkjdñlirup398750348tpñwiejdñlksjñdkjfñeoi");
        for (Map.Entry<String,Object> header : msg.getHeaders().entrySet())
        {
            log.info("Header key {} and value {}",header.getKey(), header.getValue());
        }
    }
    
}
