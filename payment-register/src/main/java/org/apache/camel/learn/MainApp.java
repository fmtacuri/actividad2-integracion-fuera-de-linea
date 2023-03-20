package org.apache.camel.learn;

import org.apache.camel.learn.route.FileRoute;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

  public static void main(String... args) throws Exception {
    Main main = new Main();
    main.configure().addRoutesBuilder(new FileRoute());
    main.run(args);
  }

}

