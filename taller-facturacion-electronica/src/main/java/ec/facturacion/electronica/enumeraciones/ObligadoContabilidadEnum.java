package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum ObligadoContabilidadEnum {
	/**
	 * Emisión normal
	 */
	@XmlEnumValue("SI")
	SI,

	/**
	 * Emisión por Indisponibilidad del Sistema
	 */
	@XmlEnumValue("NO")
	NO;
}
