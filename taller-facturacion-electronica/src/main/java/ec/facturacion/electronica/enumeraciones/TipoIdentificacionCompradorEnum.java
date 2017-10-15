package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum TipoIdentificacionCompradorEnum {
	/**
	 * RUC
	 */
	@XmlEnumValue("04")
	RUC,

	/**
	 * Cédula
	 */
	@XmlEnumValue("05")
	CEDULA,

	/**
	 * Pasaporte
	 */
	@XmlEnumValue("06")
	PASAPORTE,

	/**
	 * Venta a consumidor final
	 */
	@XmlEnumValue("07")
	CONSUMIDOR_FINAL,

	/**
	 * Identificación del exterior
	 */
	@XmlEnumValue("08")
	IDENTIFICACION_DEL_EXTERIOR,

	/**
	 * Placa
	 */
	@XmlEnumValue("09")
	PLACA;
}
