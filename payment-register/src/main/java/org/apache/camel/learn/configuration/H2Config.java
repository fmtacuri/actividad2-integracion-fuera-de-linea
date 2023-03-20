package org.apache.camel.learn.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Config {

  private static final String JDBC_DRIVER = "org.h2.Driver";
  private static final String DB_URL = "jdbc:h2:mem:testdb";
  private static final String USER = "sa";
  private static final String PASSWORD = "password";
  private Connection conn;

  public H2Config() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return conn;
  }
}
