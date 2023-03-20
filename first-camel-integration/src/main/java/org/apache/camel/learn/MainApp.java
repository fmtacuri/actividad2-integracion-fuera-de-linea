package org.apache.camel.learn;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        /*
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.configure().addRoutesBuilder(new MyRoute2());
        main.configure().addRoutesBuilder(new SaludosRouter());
        main.configure().addRoutesBuilder(new SaludosMock());
        main.configure().addRoutesBuilder(new MyRoute22());
        */

        main.configure().addRoutesBuilder(new MyBindyRoute());
        main.run(args);
    }

}

