package ec.facturacion.electronica.modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import ec.facturacion.electronica.enumeraciones.AmbienteEnum;
import ec.facturacion.electronica.enumeraciones.TipoEmisionEnum;

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

	public void setClaveAcceso(String claveAcceso) {
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