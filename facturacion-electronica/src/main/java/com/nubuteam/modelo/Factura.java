package com.nubuteam.modelo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "infoTributaria", "infoFactura", "detalles", "infoAdicional" })
@XmlSeeAlso({ InfoTributaria.class, InfoFactura.class, Detalle.class, CampoAdicional.class })
public class Factura implements Serializable {

	private static final long serialVersionUID = -4921604319752459192L;

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String version;

	@XmlElement
	private InfoTributaria infoTributaria;

	@XmlElement
	private InfoFactura infoFactura;

	@XmlElementWrapper(name = "detalles")
	@XmlElement(name = "detalle")
	private List<Detalle> detalles;

	@XmlElementWrapper(name = "infoAdicional")
	@XmlElement(name = "campoAdicional")
	private List<CampoAdicional> infoAdicional;

	public List<CampoAdicional> getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(List<CampoAdicional> infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public InfoTributaria getInfoTributaria() {
		return infoTributaria;
	}

	public void setInfoTributaria(InfoTributaria infoTributaria) {
		this.infoTributaria = infoTributaria;
	}

	public InfoFactura getInfoFactura() {
		return infoFactura;
	}

	public void setInfoFactura(InfoFactura infoFactura) {
		this.infoFactura = infoFactura;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
