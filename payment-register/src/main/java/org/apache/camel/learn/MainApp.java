package org.apache.camel.learn;

import org.apache.camel.learn.route.FileRoute;
import org.apache.camel.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Camel Application
 */
@SpringBootApplication
public class MainApp {

  public static void main(String... args) throws Exception {
    SpringApplication.run(MainApp.class, args);
    Main main = new Main();
    main.configure().addRoutesBuilder(new FileRoute());
    main.run(args);
  }

}

