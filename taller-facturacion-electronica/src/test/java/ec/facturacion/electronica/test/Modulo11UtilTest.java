package ec.facturacion.electronica.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ec.facturacion.electronica.util.Modulo11Util;

public class Modulo11UtilTest {

	@Test
	public void deberiaObtenerDigitoVerificador() {
		Modulo11Util modulo11Util = new Modulo11Util();
		assertEquals("6", modulo11Util.obtenerDigitoVerificador("41261533"), "6");
	}

}
