package ec.facturacion.electronica.enumeraciones;

public enum TipoComprobanteEnum {

	/**
	 * Factura
	 */
	FACTURA("01"),

	/**
	 * Nota de Crédito
	 */
	NOTA_DE_CREDITO("02"),

	/**
	 * Nota de Crédito
	 */
	NOTA_DE_DEBITO("05"),

	/**
	 * Nota de Crédito
	 */
	GUIA_DE_REMISION("06"),
	/**
	 * Nota de Crédito
	 */
	COMPROBANTE_DE_RETENCION("07");

	private String codigo;

	private TipoComprobanteEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
}
