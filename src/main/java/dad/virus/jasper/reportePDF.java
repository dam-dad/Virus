package dad.virus.jasper;

import javafx.util.converter.LocalDateTimeStringConverter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.*;

public class reportePDF {
    public void report() {
        try {
            List<Resultado> resultadoList = Arrays.asList(
                    new Resultado(56465, new Date())
            );

            JasperDesign jd = JRXmlLoader.load(
                    this.getClass()
                            .getResourceAsStream("/reports/Cherry.jrxml"));
            JasperReport report = JasperCompileManager.compileReport(jd);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("imageDir", this.getClass().getResourceAsStream("/image/qrcode.png"));

            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(resultadoList));

            JasperViewer visualiza = new JasperViewer(print, false);

            visualiza.setTitle("Virus");
            visualiza.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}

