package org.apache.camel.learn.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class Persona {
    
    @DataField(pos = 1)
    private String nombres;

    @DataField(pos = 2)
    private String correo;

    @DataField(pos = 3)
    private String cedula;

    @DataField(pos = 4)
    private String telefono;

    public String getNombres(){
        return nombres;
    }

    public String getCorreo(){
        return correo;
    }

    public String getCedula(){
        return cedula;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setNombres(String nom){
        nombres = nom;
    }

    public void setCorreo(String mail){
        correo = mail;
    }

    public void setCedula(String ced){
        cedula = ced;
    }

    public void setTelefono(String tel){
        telefono = tel;
    }

    @Override
    public String toString(){
        return "Persona "+nombres+" "+correo+" "+cedula+" "+telefono;
    }

}
