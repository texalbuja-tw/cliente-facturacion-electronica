package ec.facturacion.electronica.test;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ec.facturacion.electronica.ws.autorizacion.AutorizacionComprobantes;
import ec.facturacion.electronica.ws.autorizacion.AutorizacionComprobantesService;
import ec.facturacion.electronica.ws.autorizacion.RespuestaComprobante;
import ec.facturacion.electronica.ws.recepcion.RecepcionComprobantes;
import ec.facturacion.electronica.ws.recepcion.RecepcionComprobantesService;
import ec.facturacion.electronica.ws.recepcion.RespuestaSolicitud;

public class RecepcionComprobantesTest extends FacturaTest {

	@Test
	public void deberiaReceptarFactura() throws SAXParseException, CertificateException, SAXException, IOException,
			JAXBException, InterruptedException {
		RecepcionComprobantesService webServiceRecepcion = new RecepcionComprobantesService();
		RecepcionComprobantes port1 = webServiceRecepcion.getRecepcionComprobantesPort();
		RespuestaSolicitud respuestaSolicitud = port1.validarComprobante(crearByteArrayFacturaFirmada());

		if (!respuestaSolicitud.getComprobantes().getComprobante().isEmpty()) {
			for (ec.facturacion.electronica.ws.recepcion.Mensaje mensaje : respuestaSolicitud.getComprobantes()
					.getComprobante().get(0).getMensajes().getMensaje()) {
				System.out.println(mensaje.getIdentificador() + " " + mensaje.getInformacionAdicional());
			}
		}

		Thread.sleep(3000);

		AutorizacionComprobantesService webServiceAutorizzacion = new AutorizacionComprobantesService();

		AutorizacionComprobantes port2 = webServiceAutorizzacion.getAutorizacionComprobantesPort();
		RespuestaComprobante respuestaComprobante = port2
				.autorizacionComprobante(crearFactura().getInfoTributaria().getClaveAcceso());
		if (!respuestaComprobante.getAutorizaciones().getAutorizacion().isEmpty()) {
			for (ec.facturacion.electronica.ws.autorizacion.Mensaje mensaje : respuestaComprobante.getAutorizaciones()
					.getAutorizacion().get(0).getMensajes().getMensaje()) {
				System.out.println(mensaje.getIdentificador() + " " + mensaje.getInformacionAdicional());
			}
		}
	}

}
