package ec.facturacion.electronica.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ec.facturacion.electronica.util.FirmaXadesBesUtil;

public class FirmaXadesBesTest {

	@Test
	public void deberiaFirmarArchivoXML() throws Exception {
		File xml = new File("src/test/resources/xml/Factura_V_2_1_0.xml");
		FirmaXadesBesUtil firmaXadesBesUtil = new FirmaXadesBesUtil();
		firmaXadesBesUtil.firmar(xml, "src/test/resources/p12/test.p12", obtenerPasswordDesdeArchivoDeRecursos());
		File xmlFirmado = new File("src/test/resources/xml/Factura_V_2_1_0_signed.xml");
		Assert.assertTrue(xmlFirmado.exists() && !xmlFirmado.isDirectory());
	}

	public static String obtenerPasswordDesdeArchivoDeRecursos() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("src/test/resources/p12/password.txt"),
				Charset.forName("UTF-8"));
		return lines.get(0);
	}
}
