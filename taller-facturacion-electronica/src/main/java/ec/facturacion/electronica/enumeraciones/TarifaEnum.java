package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum TarifaEnum {
	/**
	 * Impuesto Redimible a las Botellas Plasticas no Retornables.
	 */
	@XmlEnumValue("0.02")
	IRBPNR,
	/**
	 * Impuesto Redimible a las Botellas Plasticas no Retornables.
	 */
	@XmlEnumValue("0")
	IVA_0;

}
