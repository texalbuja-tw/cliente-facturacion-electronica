/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.facturacion.electronica.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.BindingProvider;

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
import ec.facturacion.electronica.ws.autorizacion.AutorizacionComprobantes;
import ec.facturacion.electronica.ws.autorizacion.AutorizacionComprobantesService;
import ec.facturacion.electronica.ws.autorizacion.RespuestaComprobante;
import ec.facturacion.electronica.ws.recepcion.RecepcionComprobantes;
import ec.facturacion.electronica.ws.recepcion.RecepcionComprobantesService;
import ec.facturacion.electronica.ws.recepcion.RespuestaSolicitud;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the
 * members table.
 */
@Path("/suscribir")
@RequestScoped
public class SuscribirRESTService {
	public static Logger log = Logger.getLogger(SuscribirRESTService.class.getName());

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMember(Suscripcion suscripcion) {

		Response.ResponseBuilder builder = null;

		try {

			Factura factura = crearFactura(suscripcion);
			ByteArrayOutputStream baosFactura = (new XmlUtil()).convertirObjetoAXml(Factura.class, factura);
			FirmaXadesBesUtil firmaXadesBesUtil = new FirmaXadesBesUtil("src/test/resources/p12/test.p12",
					"2006Andrea");
			ByteArrayOutputStream baosFacturaFirmada = new ByteArrayOutputStream();
			firmaXadesBesUtil.firmarDocumento(new ByteArrayInputStream(baosFactura.toByteArray()), baosFacturaFirmada);

			RecepcionComprobantesService webServiceRecepcion = new RecepcionComprobantesService();
			RecepcionComprobantes port1 = webServiceRecepcion.getRecepcionComprobantesPort();
			RespuestaSolicitud respuestaSolicitud = port1.validarComprobante(baosFacturaFirmada.toByteArray());

			BindingProvider bindingProvider = (BindingProvider) port1;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					"http://foo:8086/HelloWhatever");

			if (!respuestaSolicitud.getComprobantes().getComprobante().isEmpty()) {
				for (ec.facturacion.electronica.ws.recepcion.Mensaje mensaje : respuestaSolicitud.getComprobantes()
						.getComprobante().get(0).getMensajes().getMensaje()) {
					System.out.println(mensaje.getIdentificador() + " " + mensaje.getInformacionAdicional());
				}
			}

			Thread.sleep(4500);

			AutorizacionComprobantesService webServiceAutorizacion = new AutorizacionComprobantesService();

			AutorizacionComprobantes port2 = webServiceAutorizacion.getAutorizacionComprobantesPort();
			RespuestaComprobante respuestaComprobante = port2
					.autorizacionComprobante(factura.getInfoTributaria().getClaveAcceso());
			if (!respuestaComprobante.getAutorizaciones().getAutorizacion().isEmpty()) {
				for (ec.facturacion.electronica.ws.autorizacion.Mensaje mensaje : respuestaComprobante
						.getAutorizaciones().getAutorizacion().get(0).getMensajes().getMensaje()) {
					System.out.println(mensaje.getIdentificador() + " " + mensaje.getInformacionAdicional());
				}
			}
			builder = Response.ok();
		} catch (ConstraintViolationException ce) {
			// Handle bean validation issues
			builder = createViolationResponse(ce.getConstraintViolations());
		} catch (ValidationException e) {
			// Handle the unique constrain violation
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("email", "Email taken");
			builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
		} catch (Exception e) {
			// Handle generic exceptions
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}

		return builder.build();
	}

	/**
	 * Creates a JAX-RS "Bad Request" response including a map of all violation
	 * fields, and their message. This can then be used by clients to show
	 * violations.
	 * 
	 * @param violations
	 *            A set of violations that needs to be reported
	 * @return JAX-RS response containing all violations
	 */
	private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
		log.fine("Validation completed. violations found: " + violations.size());

		Map<String, String> responseObj = new HashMap<>();

		for (ConstraintViolation<?> violation : violations) {
			responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
		}

		return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	}

	public Factura crearFactura(Suscripcion suscripcion) {
		Factura factura = new Factura();
		factura.setVersion("2.1.0");
		factura.setId("comprobante");
		factura.setInfoTributaria(crearInfoTributaria());
		factura.setInfoFactura(crearInfoFactura(suscripcion));
		factura.setDetalles(crearDetalles());

		return factura;
	}

	private List<Detalle> crearDetalles() {
		List<Detalle> detalles = new ArrayList<Detalle>();
		Detalle detalle = new Detalle();
		detalle.setCodigoPrincipal("831520202");
		detalle.setCodigoAuxiliar("1");
		detalle.setDescripcion("SRIFY");
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

	public InfoFactura crearInfoFactura(Suscripcion suscripcion) {
		InfoFactura infoFactura = new InfoFactura();
		infoFactura.setFechaEmision((new SimpleDateFormat("dd/MM/YYYY")).format(new Date()));
		infoFactura.setDirEstablecimiento("Calle: DUCHICELA Numero: OE8-345 Interseccion: SHIRYS ");
		infoFactura.setObligadoContabilidad(ObligadoContabilidadEnum.NO);
		infoFactura.setTipoIdentificacionComprador(TipoIdentificacionCompradorEnum.RUC);
		infoFactura.setRazonSocialComprador("RAZON SOCIAL DEL COMPRADOR");
		infoFactura.setIdentificacionComprador(suscripcion.getIdentificacion());
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
