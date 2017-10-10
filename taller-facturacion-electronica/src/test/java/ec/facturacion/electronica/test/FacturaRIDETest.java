package ec.facturacion.electronica.test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.w3c.dom.Document;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRXmlUtils;

public class FacturaRIDETest {

	@Test
	public void deberiaExportarRIDEFactura() throws JRException {
		long start = System.currentTimeMillis();
		Map params = new HashMap();
		Document document = JRXmlUtils
				.parse(JRLoader.getLocationInputStream("src/test/resources/xml/Factura_V_2_1_0.xml"));
		params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
		params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
		params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
		params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
		params.put(JRParameter.REPORT_LOCALE, Locale.US);

		JasperFillManager.fillReportToFile("src/main/java/ec/facturacion/electronica/ride/Factura_V_2_1_0.jasper",
				params);
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}
}
