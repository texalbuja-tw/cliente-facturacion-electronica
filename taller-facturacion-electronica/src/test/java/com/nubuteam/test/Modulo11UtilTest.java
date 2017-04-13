package com.nubuteam.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.nubuteam.util.Modulo11Util;

public class Modulo11UtilTest {

	@Test
	public void deberiaObtenerDigitoVerificador() {
		assertEquals("6", Modulo11Util.obtenerDigitoVerificador("41261533"), "6");
	}

}
