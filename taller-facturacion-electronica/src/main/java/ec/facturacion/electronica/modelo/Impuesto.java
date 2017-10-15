package ec.facturacion.electronica.modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ec.facturacion.electronica.enumeraciones.CodigoPorcentajeEnum;
import ec.facturacion.electronica.enumeraciones.CodigoImpuestoEnum;
import ec.facturacion.electronica.enumeraciones.TarifaEnum;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor" })
public class Impuesto implements Serializable {

	private static final long serialVersionUID = 6042092285712677811L;

	@XmlElement
	private CodigoImpuestoEnum codigo;
	@XmlElement
	private CodigoPorcentajeEnum codigoPorcentaje;
	@XmlElement
	private TarifaEnum tarifa;
	@XmlElement
	private String baseImponible;
	@XmlElement
	private String valor;

	public CodigoImpuestoEnum getCodigo() {
		return codigo;
	}

	public void setCodigo(CodigoImpuestoEnum impuesto) {
		this.codigo = impuesto;
	}

	public CodigoPorcentajeEnum getCodigoPorcentaje() {
		return codigoPorcentaje;
	}

	public void setCodigoPorcentaje(CodigoPorcentajeEnum codigoPorcentaje) {
		this.codigoPorcentaje = codigoPorcentaje;
	}

	public TarifaEnum getTarifa() {
		return tarifa;
	}

	public void setTarifa(TarifaEnum tarifaEnum) {
		this.tarifa = tarifaEnum;
	}

	public String getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(String baseImponible) {
		this.baseImponible = baseImponible;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}