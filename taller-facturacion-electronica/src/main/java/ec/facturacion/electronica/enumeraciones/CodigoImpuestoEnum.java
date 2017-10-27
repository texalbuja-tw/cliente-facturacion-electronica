package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum CodigoImpuestoEnum {
	/**
	 * Impuesto al Valor Agregado
	 */
	@XmlEnumValue("2")
	IVA,
	/**
	 * Impuesto a los consumos especiales
	 */
	@XmlEnumValue("3")
	ICE,
	/**
	 * Impuesto Redimible a las Botellas Plasticas No renovables
	 */
	@XmlEnumValue("5")
	IRBPNR;
}
