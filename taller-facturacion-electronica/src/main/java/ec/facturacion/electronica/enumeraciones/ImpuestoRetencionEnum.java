package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum ImpuestoRetencionEnum {
	/**
	 * Impuesto a la Renta
	 */
	@XmlEnumValue("1")
	RENTA,
	/**
	 * Impuesto al Valor Agregado
	 */
	@XmlEnumValue("2")
	IVA,
	/**
	 * Impuesto a la Salida de Divisas
	 */
	@XmlEnumValue("6")
	ISD;
}
