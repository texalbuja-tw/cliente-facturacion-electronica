package com.nubuteam.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.nubuteam.modelo.Factura;
import com.nubuteam.util.XmlUtil;

public class FacturaTest {

	@Test
	public void deberiaValidarGeneracionDeXml() throws SAXException, IOException, JAXBException {
		Factura factura = new Factura();
		factura.setVersion("2.1.0");
		factura.setId("comprobante");
		assertTrue(XmlUtil.validaQueUnaClaseCumplaConUnXSD(Factura.class, factura, "Factura.xsd"));
	}
}
