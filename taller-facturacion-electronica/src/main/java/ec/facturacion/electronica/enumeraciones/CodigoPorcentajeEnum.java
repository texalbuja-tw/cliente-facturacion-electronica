package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum CodigoPorcentajeEnum {
	/**
	 * Porcentaje 0%
	 */
	@XmlEnumValue("0")
	IVA_0,

	/**
	 * Porcentaje 12%
	 */
	@XmlEnumValue("2")
	IVA_12,
	/**
	 * Porcentaje 14%
	 */
	@XmlEnumValue("3")
	IVA_14,

	/**
	 * No objeto de impuesto
	 */
	@XmlEnumValue("6")
	IVA_NO_OBJETO_DE_IMPUESTO,

	/**
	 * Excento de Iva
	 */
	@XmlEnumValue("7")
	IVA_EXCENTO,

	/**
	 * 150% Productos del tabaco y sucedaneos del tabaco (abarcan los productos
	 * preparados totalmente o en parte utilizando como materia prima hojas de
	 * tabaco y destinados a ser fumados, chupados, inhalados, mascados o
	 * utilizados como rape)
	 */
	@XmlEnumValue("3023")
	ICE_3023,
	/**
	 * 20% Perfumes y aguas de tocador
	 */
	@XmlEnumValue("3610")
	ICE_3610,

	/**
	 * 35% Videojuegos
	 */
	@XmlEnumValue("3620")
	ICE_3620,

	/**
	 * 300% Armas de fuego, armas deportivas y municiones excepto aquellas
	 * adquiridas por la fuerza publica
	 */
	@XmlEnumValue("3630")
	ICE_3630,

	/**
	 * 100% Focos incandescentes excepto aquellos utilizados como insumos
	 * automotrices
	 */
	@XmlEnumValue("3640")
	ICE_3640,

	/**
	 * 100% Cocinas,calefones y otros de uso domestico a gas SRI
	 */
	@XmlEnumValue("3670")
	ICE_3670,

	/**
	 * 100% Cocinas, calefones y otros de uso domestico a gas SENAE
	 */
	@XmlEnumValue("3770")
	ICE_3770;
}
