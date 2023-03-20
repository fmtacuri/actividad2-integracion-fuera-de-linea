package org.apache.camel.learn;

import org.springframework.stereotype.Component;

@Component("MiBean")
public class MyBean {

  public String aMayusculas(String dato) {
    return dato.toUpperCase();
  }
}
