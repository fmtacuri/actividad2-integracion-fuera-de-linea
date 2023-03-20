package org.apache.camel.learn;

public class MaskDNI {

    public String mask(String data){
        return data.replaceAll(".(?=.{10})", "*");
    }
    
}
