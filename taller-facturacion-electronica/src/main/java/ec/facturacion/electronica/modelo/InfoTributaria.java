package ec.facturacion.electronica.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import ec.facturacion.electronica.enumeraciones.AmbienteEnum;
import ec.facturacion.electronica.enumeraciones.TipoComprobanteEnum;
import ec.facturacion.electronica.enumeraciones.TipoEmisionEnum;
import ec.facturacion.electronica.util.Modulo11Util;
import sun.util.logging.resources.logging;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "ambiente", "tipoEmision", "razonSocial", "nombreComercial", "ruc", "claveAcceso", "codDoc",
		"estab", "ptoEmi", "secuencial", "dirMatriz" })
@XmlSeeAlso({ InfoTributaria.class, InfoFactura.class, Detalle.class })
public class InfoTributaria implements Serializable {

	private static final long serialVersionUID = -2944593528360945418L;

	@XmlElement
	private AmbienteEnum ambiente;

	@XmlElement
	private TipoEmisionEnum tipoEmision;

	@XmlElement
	private String razonSocial;

	@XmlElement
	private String nombreComercial;

	@XmlElement
	private String ruc;

	@XmlElement
	private String claveAcceso;

	@XmlElement
	private String codDoc;

	@XmlElement
	private String estab;

	@XmlElement
	private String ptoEmi;

	@XmlElement
	private String secuencial;

	@XmlElement
	private String dirMatriz;

	public AmbienteEnum getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(AmbienteEnum ambiente) {
		this.ambiente = ambiente;
	}

	public TipoEmisionEnum getTipoEmision() {
		return tipoEmision;
	}

	public void setTipoEmision(TipoEmisionEnum tipoEmision) {
		this.tipoEmision = tipoEmision;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void generarClaveAcceso(Date fechaEmision, TipoComprobanteEnum tipoComprobante, String codigoNumerico) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		if (codigoNumerico.length() != 8) {
			throw new IllegalArgumentException("Codigo numerico debe tener 8 digitos");
		}
		if (ruc == null) {
			throw new IllegalArgumentException("Numero de ruc no asignado");
		}
		if (ambiente == null) {
			throw new IllegalArgumentException("Ambiente no asignado");
		}
		if (estab == null) {
			throw new IllegalArgumentException("Establecimiento no asignado");
		}
		if (ptoEmi == null) {
			throw new IllegalArgumentException("Punto de Emision no asignado");
		}
		if (tipoEmision == null) {
			throw new IllegalArgumentException("Tipo de Emision no asignado");
		}
		if (secuencial == null) {
			throw new IllegalArgumentException("Secuencial no asignado");
		}
		String claveSinDigitoVerificador = sdf.format(fechaEmision) + tipoComprobante.getCodigo() + ruc
				+ ambiente.getCodigo() + estab + ptoEmi + secuencial + codigoNumerico + tipoEmision.getCodigo();
		Modulo11Util modulo11Util = new Modulo11Util();

		String claveAcceso = claveSinDigitoVerificador
				+ modulo11Util.obtenerDigitoVerificador(claveSinDigitoVerificador);
		if (claveAcceso.length() != 49) {
			throw new IllegalArgumentException("Clave de acceso debe tener 49 digitos, actual: " + claveAcceso);
		}
		System.out.println("Clave de Acceso" + claveAcceso + "\n");
		this.claveAcceso = claveAcceso;
	}

	public String getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}

	public String getEstab() {
		return estab;
	}

	public void setEstab(String estab) {
		this.estab = estab;
	}

	public String getPtoEmi() {
		return ptoEmi;
	}

	public void setPtoEmi(String ptoEmi) {
		this.ptoEmi = ptoEmi;
	}

	public String getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}

	public String getDirMatriz() {
		return dirMatriz;
	}

	public void setDirMatriz(String dirMatriz) {
		this.dirMatriz = dirMatriz;
	}
}