package ec.facturacion.electronica.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ec.facturacion.electronica.enumeraciones.AmbienteEnum;
import ec.facturacion.electronica.enumeraciones.CodigoImpuestoEnum;
import ec.facturacion.electronica.enumeraciones.CodigoPorcentajeEnum;
import ec.facturacion.electronica.enumeraciones.FormaPagoEnum;
import ec.facturacion.electronica.enumeraciones.MonedaEnum;
import ec.facturacion.electronica.enumeraciones.ObligadoContabilidadEnum;
import ec.facturacion.electronica.enumeraciones.TarifaEnum;
import ec.facturacion.electronica.enumeraciones.TipoComprobanteEnum;
import ec.facturacion.electronica.enumeraciones.TipoEmisionEnum;
import ec.facturacion.electronica.enumeraciones.TipoIdentificacionCompradorEnum;
import ec.facturacion.electronica.modelo.DetAdicional;
import ec.facturacion.electronica.modelo.Detalle;
import ec.facturacion.electronica.modelo.Factura;
import ec.facturacion.electronica.modelo.Impuesto;
import ec.facturacion.electronica.modelo.InfoFactura;
import ec.facturacion.electronica.modelo.InfoTributaria;
import ec.facturacion.electronica.modelo.Pago;
import ec.facturacion.electronica.modelo.TotalImpuesto;
import ec.facturacion.electronica.util.FirmaXadesBesUtil;
import ec.facturacion.electronica.util.XmlUtil;

public class FacturaTest {

	public void deberiaValidarFacturaFirmadaConEsquema() throws Exception {
		ByteArrayOutputStream baosFirmado = crearFacturaFirmada();
		InputStream is = new ByteArrayInputStream(baosFirmado.toByteArray());
		XmlUtil.validarQueUnXmlCumpleConXSD(is, "src/test/resources/xsd/Factura_V_2_1_0.xsd");

	}

	protected byte[] crearByteArrayFacturaFirmada()
			throws SAXParseException, CertificateException, SAXException, IOException, JAXBException {
		ByteArrayOutputStream baosFirmado = crearFacturaFirmada();
		return baosFirmado.toByteArray();
	}

	private ByteArrayOutputStream crearFacturaFirmada()
			throws SAXParseException, SAXException, IOException, JAXBException, CertificateException {
		ByteArrayOutputStream baosFactura = (new XmlUtil()).convertirObjetoAXml(Factura.class, crearFactura());
		FirmaXadesBesUtil firmaXadesBesUtil = new FirmaXadesBesUtil("src/test/resources/p12/test.p12",
				obtenerPasswordDesdeArchivoDeRecursos());
		ByteArrayOutputStream baosFacturaFirmada = new ByteArrayOutputStream();
		firmaXadesBesUtil.firmarDocumento(new ByteArrayInputStream(baosFactura.toByteArray()), baosFacturaFirmada);
		return baosFactura;
	}

	public static String obtenerPasswordDesdeArchivoDeRecursos() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("src/test/resources/p12/password.txt"),
				Charset.forName("UTF-8"));
		return lines.get(0);
	}

	public Factura crearFactura() {
		Factura factura = new Factura();
		factura.setVersion("2.1.0");
		factura.setId("comprobante");
		factura.setInfoTributaria(crearInfoTributaria());
		factura.setInfoFactura(crearInfoFactura());
		factura.setDetalles(crearDetalles());

		return factura;
	}

	private List<Detalle> crearDetalles() {
		List<Detalle> detalles = new ArrayList<Detalle>();
		Detalle detalle = new Detalle();
		detalle.setCodigoPrincipal("831520202");
		detalle.setCodigoAuxiliar("1");
		detalle.setDescripcion("APROVISIONAMIENTO DE SOFTWARE DE GESTION ESTUDIANTIL");
		detalle.setCantidad("1.00");
		detalle.setPrecioUnitario("1.00");
		detalle.setPrecioTotalSinImpuesto("1.00");
		detalle.setDescuento("0.00");
		detalles.add(detalle);

		List<DetAdicional> detallesAdicionales = new ArrayList<DetAdicional>();
		DetAdicional detAdicional = new DetAdicional();
		detallesAdicionales.add(detAdicional);
		detAdicional.setNombre("nombre");
		detAdicional.setValor("valor");
		detalle.setDetallesAdicionales(detallesAdicionales);

		List<Impuesto> impuestos = new ArrayList<Impuesto>();
		Impuesto impuesto = new Impuesto();
		impuestos.add(impuesto);
		impuesto.setCodigo(CodigoImpuestoEnum.IVA);
		impuesto.setCodigoPorcentaje(CodigoPorcentajeEnum.IVA_0);
		impuesto.setTarifa(TarifaEnum.IVA_0);
		impuesto.setBaseImponible("1.00");
		impuesto.setValor("0.14");
		detalle.setImpuestos(impuestos);

		return detalles;
	}

	public InfoFactura crearInfoFactura() {
		InfoFactura infoFactura = new InfoFactura();
		infoFactura.setFechaEmision((new SimpleDateFormat("dd/MM/YYYY")).format(new Date()));
		infoFactura.setDirEstablecimiento("Calle: DUCHICELA Numero: OE8-345 Interseccion: SHIRYS ");
		infoFactura.setObligadoContabilidad(ObligadoContabilidadEnum.NO);
		infoFactura.setTipoIdentificacionComprador(TipoIdentificacionCompradorEnum.RUC);
		infoFactura.setRazonSocialComprador("RAZON SOCIAL DEL COMPRADOR");
		infoFactura.setIdentificacionComprador("1792186293001");
		infoFactura.setTotalSinImpuestos("1.00");
		infoFactura.setTotalDescuento("0.00");
		infoFactura.setTotalConImpuestos(crearTotalImpuestos());
		infoFactura.setImporteTotal("1.14");
		infoFactura.setMoneda(MonedaEnum.DOLAR);
		infoFactura.setPagos(crearPagos());
		return infoFactura;
	}

	private List<Pago> crearPagos() {
		List<Pago> pagos = new ArrayList<Pago>();
		Pago pago = new Pago();
		pago.setFormaPago(FormaPagoEnum.SIN_UTILIZACION_DEL_SISTEMA_FINANCIERO);
		pago.setTotal("1.14");
		pagos.add(pago);
		return pagos;
	}

	public List<TotalImpuesto> crearTotalImpuestos() {
		List<TotalImpuesto> totalImpuestos = new ArrayList<TotalImpuesto>();
		TotalImpuesto totalImpuesto = new TotalImpuesto();
		totalImpuesto.setCodigo(CodigoImpuestoEnum.IVA);
		totalImpuesto.setCodigoPorcentaje(CodigoPorcentajeEnum.IVA_14);
		totalImpuesto.setTarifa(TarifaEnum.IVA_0);
		totalImpuesto.setBaseImponible("1.00");
		totalImpuesto.setValor("0.14");
		totalImpuestos.add(totalImpuesto);
		return totalImpuestos;
	}

	public InfoTributaria crearInfoTributaria() {
		InfoTributaria infoTributaria = new InfoTributaria();
		infoTributaria.setAmbiente(AmbienteEnum.PRUEBAS);
		infoTributaria.setTipoEmision(TipoEmisionEnum.NORMAL);
		infoTributaria.setRazonSocial("ANDREA ESTEFANIA SUQUILLO NAVARRETE");
		infoTributaria.setNombreComercial("NOMBRE COMERCIAL");
		infoTributaria.setDirMatriz("DIRECCION MATRIZ");
		infoTributaria.setRuc("1719761767001");
		infoTributaria.setCodDoc("01");
		infoTributaria.setEstab("001");
		infoTributaria.setPtoEmi("100");
		Random rn = new Random();
		int n = 100000001 - 999999999 + 1;
		int i = rn.nextInt() % n;
		int random = 100000000 + i;
		infoTributaria.setSecuencial(String.valueOf(random));
		Calendar cal = Calendar.getInstance();

		infoTributaria.generarClaveAcceso(cal.getTime(), TipoComprobanteEnum.FACTURA, "12345678");

		infoTributaria.setDirMatriz("Calle: Dir. Matri Numero: OE8-345 Interseccion: Dir. Matriz");
		return infoTributaria;
	}
}
