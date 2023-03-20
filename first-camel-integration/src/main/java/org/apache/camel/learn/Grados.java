package org.apache.camel.learn;

public class Grados {

    public String convertCenFa(String data){
        float cen = new Float(data).floatValue();
        float fan = ((cen*9)/5)+32;
        return new Float(fan).toString();
    }
    
}
