package org.apache.camel.learn;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiServicio2 {

  @Autowired
  private ProducerTemplate template;

  @GetMapping(value = "/hola/{nombre}")
  public String hola(@PathVariable("nombre") String nombre) {
    return template.requestBody("direct:saludomod", nombre).toString();
  }

  @GetMapping(value = "/lista-persona")
  public String consultaPersonas() {
    return template.requestBody("direct:personas", "").toString();
  }

  @GetMapping(value = "/lista-persona/{codigo}")
  public String consultaPersona(@PathVariable("codigo") String codigo) {
    return template.requestBodyAndHeader("direct:persona", null, "codigo", codigo).toString();
  }

  @PostMapping(value = "/crear-persona")
  public String crearPersona() {
    return template.requestBody("direct:crearPersona", "").toString();
  }

  @PostMapping(value = "/crear-todos")
  public String crearTerceros() {
    return template.requestBody("direct:crearAll", "").toString();
  }
}
