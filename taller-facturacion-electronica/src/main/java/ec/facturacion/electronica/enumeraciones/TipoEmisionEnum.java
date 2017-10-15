package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum TipoEmisionEnum {
	/**
	 * Emisión normal
	 */
	@XmlEnumValue("1")
	NORMAL,

	/**
	 * Emisión por Indisponibilidad del Sistema
	 */
	@XmlEnumValue("2")
	INDISPONIBILIDAD;
}
