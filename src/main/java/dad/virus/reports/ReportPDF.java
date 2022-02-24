package dad.virus.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.*;

/**
 * Clase Reporte pdf.
 */
public class ReportPDF {
    /**
     * Reporte
     */
    public void report(String tiempoJugado, int nTiradas) throws JRException {
        try {
            List<Result> resultadoList = Arrays.asList(
                    new Result(tiempoJugado, new Date(), nTiradas)
            );

            JasperDesign jd = JRXmlLoader.load(
                    this.getClass()
                            .getResourceAsStream("/reports/report.jrxml"));
            JasperReport report = JasperCompileManager.compileReport(jd);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("imageDir", this.getClass().getResourceAsStream("/image/report/qrcode.png"));
            parameters.put("imageDir2", this.getClass().getResourceAsStream("/image/report/virusImgPdf.png"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(resultadoList));

            JasperViewer visualiza = new JasperViewer(print, false);
            visualiza.setTitle("Virus");
            visualiza.setVisible(true);

            JasperExportManager.exportReportToPdfFile(print, ".");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}

