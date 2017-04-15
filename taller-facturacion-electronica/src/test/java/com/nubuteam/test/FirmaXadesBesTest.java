package com.nubuteam.test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.nubuteam.util.FirmaXadesBesUtil;

public class FirmaXadesBesTest {

	@Test
	public void deberiaFirmarArchivoXML() throws Exception {
		File xml = new File("src/test/resources/xml/Factura_V_2_1_0.xml");
		FirmaXadesBesUtil firmaXadesBesUtil = new FirmaXadesBesUtil();
		firmaXadesBesUtil.firmar(xml, "src/test/resources/p12/test.p12", "2006Andrea");
		File xmlFirmado = new File("src/test/resources/xml/Factura_V_2_1_0_signed.xml");
		Assert.assertTrue(xmlFirmado.exists() && !xmlFirmado.isDirectory());
	}

}
