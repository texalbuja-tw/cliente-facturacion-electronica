package com.nubuteam.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.nubuteam.modelo.Factura;

public class FacturaTest {
	@Test
	public void deberiaCrearUnaNuevaFactura() {
		Factura factura = new Factura();
		assertNotNull(factura);
	}

	@Test
	public void deberiaValidarEstructuraXml(Factura factura) {
		
	}
}
