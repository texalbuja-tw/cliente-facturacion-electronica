package ec.facturacion.electronica.test;

import org.junit.Test;

import ec.facturacion.electronica.ws.autorizacion.AutorizacionComprobantes;
import ec.facturacion.electronica.ws.autorizacion.AutorizacionComprobantesService;

public class AutorizacionComprobantesTest extends FacturaTest {

	@Test
	public void deberiaAutorizarFactura() {
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		AutorizacionComprobantesService service1 = new AutorizacionComprobantesService();
		System.out.println("Create Web Service...");
		AutorizacionComprobantes port1 = service1.getAutorizacionComprobantesPort();
		System.out.println("Call Web Service Operation...");
		System.out.println("Server said: " + port1.autorizacionComprobante(null));
		// Please input the parameters instead of 'null' for the upper method!

		System.out.println("Server said: " + port1.autorizacionComprobanteLote(null));
		// Please input the parameters instead of 'null' for the upper method!

		System.out.println("Create Web Service...");
		AutorizacionComprobantes port2 = service1.getAutorizacionComprobantesPort();
		System.out.println("Call Web Service Operation...");
		System.out.println("Server said: " + port2.autorizacionComprobante(null));
		// Please input the parameters instead of 'null' for the upper method!

		System.out.println("Server said: " + port2.autorizacionComprobanteLote(null));
		// Please input the parameters instead of 'null' for the upper method!

		System.out.println("***********************");
		System.out.println("Call Over!");
	}

}
