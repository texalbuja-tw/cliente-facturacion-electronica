package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FormaPagoEnum {
	/**
	 * Sin utilizacion del sistema de financiero
	 */
	@XmlEnumValue("01")
	SIN_UTILIZACION_DEL_SISTEMA_FINANCIERO,

	/**
	 * Compensacion de deudas
	 * 
	 */
	@XmlEnumValue("15")
	COMPENSACION_DE_DEUDAS,
	/**
	 * Tarjeta de debito
	 */
	@XmlEnumValue("16")
	TARJETA_DE_DEBITO,
	/**
	 * Dinero electronico
	 */
	@XmlEnumValue("17")
	DINERO_ELECTRONICO,
	/**
	 * Impuesto a la Salida de Divisas
	 */
	@XmlEnumValue("18")
	TARJETA_PREPAGO,
	/**
	 * Tarjetas de credito
	 */
	@XmlEnumValue("19")
	TARJETA_DE_CREDITO,
	/**
	 * Otros con utilizacion del sistema Financiero
	 */
	@XmlEnumValue("20")
	OTROS_CON_UTILIZACION_DEL_SISTEMA_FINANCIERO,
	/**
	 * Endoso de Titulos
	 */
	@XmlEnumValue("21")
	ENDOSO_DE_TITULOS;
}
