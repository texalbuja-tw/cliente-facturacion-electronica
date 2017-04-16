package com.nubuteam.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nubuteam.modelo.DetAdicional;
import com.nubuteam.modelo.Detalle;
import com.nubuteam.modelo.Factura;
import com.nubuteam.modelo.Impuesto;
import com.nubuteam.modelo.InfoFactura;
import com.nubuteam.modelo.InfoTributaria;
import com.nubuteam.modelo.Pago;
import com.nubuteam.modelo.TotalImpuesto;
import com.nubuteam.util.FirmaXadesBesUtil;
import com.nubuteam.util.XmlUtil;

public class FacturaTest {

	@Test
	public void deberiaValidarFacturaFirmadaConEsquema() throws Exception {
		File xmlFactura = XmlUtil.convertirObjetoAXml(Factura.class, crearFactura());
		FirmaXadesBesUtil firmaXadesBesUtil = new FirmaXadesBesUtil();
		File xmlFirmado = firmaXadesBesUtil.firmar(xmlFactura, "src/test/resources/p12/test.p12",obtenerPasswordDesdeArchivoDeRecursos());
		XmlUtil.validarQueUnXmlCumpleConXSD(xmlFirmado, "src/test/resources/xsd/Factura_V_2_1_0.xsd");

	}

	public static String obtenerPasswordDesdeArchivoDeRecursos() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("src/test/resources/p12/password.txt"),
				Charset.forName("UTF-8"));
		return lines.get(0);
	}

	public static Factura crearFactura() {
		Factura factura = new Factura();
		factura.setVersion("2.1.0");
		factura.setId("comprobante");
		factura.setInfoTributaria(crearInfoTributaria());
		factura.setInfoFactura(crearInfoFactura());
		factura.setDetalles(crearDetalles());

		return factura;
	}

	private static List<Detalle> crearDetalles() {
		List<Detalle> detalles = new ArrayList<Detalle>();
		Detalle detalle = new Detalle();
		detalle.setCodigoPrincipal("831520202");
		detalle.setCodigoAuxiliar("1");
		detalle.setDescripcion("APROVISIONAMIENTO DE SOFTWARE DE GESTIÓN ESTUDIANTIL");
		detalle.setCantidad("357.00");
		detalle.setPrecioUnitario("1.00");
		detalle.setPrecioTotalSinImpuesto("357.00");
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
		impuesto.setCodigo("2");
		impuesto.setCodigoPorcentaje("0");
		impuesto.setTarifa("49.50");
		impuesto.setBaseImponible("357.00");
		impuesto.setValor("40.30");
		detalle.setImpuestos(impuestos);

		return detalles;
	}

	public static InfoFactura crearInfoFactura() {
		InfoFactura infoFactura = new InfoFactura();
		infoFactura.setFechaEmision("30/11/2016");
		infoFactura.setDirEstablecimiento("Calle: DUCHICELA Número: OE8-345 Intersección: SHIRYS ");
		infoFactura.setObligadoContabilidad("NO");
		infoFactura.setTipoIdentificacionComprador("04");
		infoFactura.setRazonSocialComprador("COLEGIO PARTICULAR CRISTO DEL CONSUELO ");
		infoFactura.setIdentificacionComprador("1792186293001");
		infoFactura.setTotalSinImpuestos("357.00");
		infoFactura.setTotalDescuento("0.00");
		infoFactura.setTotalConImpuestos(crearTotalImpuestos());
		infoFactura.setImporteTotal("406.98");
		infoFactura.setMoneda("DOLAR");
		infoFactura.setPagos(crearPagos());
		return infoFactura;
	}

	private static List<Pago> crearPagos() {
		List<Pago> pagos = new ArrayList<Pago>();
		Pago pago = new Pago();
		pago.setFormaPago("01");
		pago.setTotal("406.98");
		pagos.add(pago);
		return pagos;
	}

	public static List<TotalImpuesto> crearTotalImpuestos() {
		List<TotalImpuesto> totalImpuestos = new ArrayList<TotalImpuesto>();
		TotalImpuesto totalImpuesto = new TotalImpuesto();
		totalImpuesto.setCodigo("2");
		totalImpuesto.setCodigoPorcentaje("3");
		totalImpuesto.setBaseImponible("357.00");
		totalImpuesto.setValor("49.98");
		totalImpuestos.add(totalImpuesto);
		return totalImpuestos;
	}

	public static InfoTributaria crearInfoTributaria() {
		InfoTributaria infoTributaria = new InfoTributaria();
		infoTributaria.setAmbiente("1");
		infoTributaria.setTipoEmision("1");
		infoTributaria.setRazonSocial("SUQUILLO NAVARRETE ANDREA ESTEFANIA");
		infoTributaria.setNombreComercial("SUQUILLO NAVARRETE ANDREA ESTEFANIA");
		infoTributaria.setDirMatriz("SHYRIS Y DUCHICELA");
		infoTributaria.setRuc("1719761767001");
		infoTributaria.setClaveAcceso("1234567890123456789012345678901234567890123465789");
		infoTributaria.setCodDoc("01");
		infoTributaria.setEstab("001");
		infoTributaria.setPtoEmi("100");
		infoTributaria.setSecuencial("000000007");
		infoTributaria.setDirMatriz("Calle: DUCHICELA Número: OE8-345 Intersección: SHIRYS ");
		return infoTributaria;
	}
}
