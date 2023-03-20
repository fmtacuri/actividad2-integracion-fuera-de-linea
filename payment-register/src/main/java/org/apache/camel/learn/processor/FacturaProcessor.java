package org.apache.camel.learn.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.learn.domain.Factura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacturaProcessor implements Processor {

  private final Logger log = LoggerFactory.getLogger(FacturaProcessor.class);

  @Override
  public void process(Exchange exchange) {
    try {
      String line = (String) exchange.getIn().getBody();
//      log.debug("line: {}", line);
      String[] streamLine = line.split(",");

      Factura factura = new Factura();

      if (!"ID".equals(streamLine[0])) {
        exchange.getIn().setHeader("id-parameter", Integer.parseInt(streamLine[0]));
        factura.setiD(Integer.parseInt(streamLine[0]));
        factura.setlIMITBAL(Integer.parseInt(streamLine[1]));
        factura.setsEX(Integer.parseInt(streamLine[2]));
        factura.seteDUCATION(Integer.parseInt(streamLine[3]));
        factura.setmARRIAGE(Integer.parseInt(streamLine[4]));
        factura.setaGE(Integer.parseInt(streamLine[5]));
        factura.setpAY0(Integer.parseInt(streamLine[6]));
        factura.setpAY2(Integer.parseInt(streamLine[7]));
        factura.setpAY3(Integer.parseInt(streamLine[8]));
        factura.setpAY4(Integer.parseInt(streamLine[9]));
        factura.setpAY5(Integer.parseInt(streamLine[10]));
        factura.setpAY6(Integer.parseInt(streamLine[11]));
        factura.setbILL1(Integer.parseInt(streamLine[12]));
        factura.setbILL2(Integer.parseInt(streamLine[13]));
        factura.setbILL3(Integer.parseInt(streamLine[14]));
        factura.setbILL4(Integer.parseInt(streamLine[15]));
        factura.setbILL5(Integer.parseInt(streamLine[16]));
        factura.setbILL6(Integer.parseInt(streamLine[17]));
        factura.setpAY1(Integer.parseInt(streamLine[18]));
        factura.setpAY2(Integer.parseInt(streamLine[19]));
        factura.setpAY3(Integer.parseInt(streamLine[20]));
        factura.setpAY4(Integer.parseInt(streamLine[21]));
        factura.setpAY5(Integer.parseInt(streamLine[22]));
        factura.setpAY6(Integer.parseInt(streamLine[23]));
        factura.setDefaultPaymentNextMonth(Integer.parseInt(streamLine[24]));
      }

    } catch (Exception exception) {
      log.error("Error in processor: FacturaProcessor, with message: {}", exception.getMessage());
    }
  }
}
