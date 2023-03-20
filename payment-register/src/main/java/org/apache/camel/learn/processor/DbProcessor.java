package org.apache.camel.learn.processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.learn.H2Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbProcessor implements Processor {


  private final Logger log = LoggerFactory.getLogger(DbProcessor.class);
  H2Config manager = new H2Config();

  @Override
  public void process(Exchange exchange) {
    try {
      Connection conn = manager.getConnection();
      String sql = "INSERT INTO payment (id, id_pay) VALUES (?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, String.valueOf(UUID.randomUUID()));
      pstmt.setString(2, exchange.getIn().getHeader("id-parameter").toString());
      int rows = pstmt.executeUpdate();
      log.info("{} rows affected.", rows);
    } catch (Exception exception) {
      log.error("Error in processor: DbProcessor, with message: {}", exception.getMessage());
    }
  }
}
