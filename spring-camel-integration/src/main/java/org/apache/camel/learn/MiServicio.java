package org.apache.camel.learn;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiServicio {

    @GetMapping(value = "/echo/{param}")
    public String echo( @PathVariable("param") String ping){
        return "Ingreso " + ping;
    }
    
}
