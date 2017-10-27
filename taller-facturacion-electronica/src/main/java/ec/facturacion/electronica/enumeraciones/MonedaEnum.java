package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum MonedaEnum {
	/**
	 * Emision normal
	 */
	@XmlEnumValue("DOLAR")
	DOLAR;
}
