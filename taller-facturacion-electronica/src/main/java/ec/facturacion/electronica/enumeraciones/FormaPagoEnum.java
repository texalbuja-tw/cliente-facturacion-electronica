package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FormaPagoEnum {
	/**
	 * Sin utilización del sistema de financiero
	 */
	@XmlEnumValue("01")
	SIN_UTILIZACION_DEL_SISTEMA_FINANCIERO,

	/**
	 * Compensación de deudas
	 * 
	 */
	@XmlEnumValue("15")
	COMPENSACION_DE_DEUDAS,
	/**
	 * Tarjeta de débito
	 */
	@XmlEnumValue("16")
	TARJETA_DE_DEBITO,
	/**
	 * Dinero electrónico
	 */
	@XmlEnumValue("17")
	DINERO_ELECTRONICO,
	/**
	 * Impuesto a la Salida de Divisas
	 */
	@XmlEnumValue("18")
	TARJETA_PREPAGO,
	/**
	 * Tarjetas de crédito
	 */
	@XmlEnumValue("19")
	TARJETA_DE_CREDITO,
	/**
	 * Otros con utilización del sistema Financiero
	 */
	@XmlEnumValue("20")
	OTROS_CON_UTILIZACION_DEL_SISTEMA_FINANCIERO,
	/**
	 * Endoso de Títulos
	 */
	@XmlEnumValue("21")
	ENDOSO_DE_TITULOS;
}
