package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum ObligadoContabilidadEnum {
	/**
	 * Emision normal
	 */
	@XmlEnumValue("SI")
	SI,

	/**
	 * Emision por Indisponibilidad del Sistema
	 */
	@XmlEnumValue("NO")
	NO;
}
