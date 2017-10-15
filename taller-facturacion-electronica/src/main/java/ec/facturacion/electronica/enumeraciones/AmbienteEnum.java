package ec.facturacion.electronica.enumeraciones;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AmbienteEnum {
	/**
	 * Ambiente de pruebas
	 */
	@XmlEnumValue("1")
	PRUEBAS("https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl", "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantes?wsdl"),

	/**
	 * Ambiente de producción
	 */
	@XmlEnumValue("2")
	PRODUCCION("https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl", "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantes?wsdl");

	private String urlRecepcion;
	private String urlAutorizacion;

	private AmbienteEnum(String urlRecepcion, String urlAutorizacion) {

		this.urlRecepcion = urlRecepcion;
		this.urlAutorizacion = urlAutorizacion;
	}

	public String getUrlRecepcion() {
		return urlRecepcion;
	}

	public String getUrlAutorizacion() {
		return urlAutorizacion;
	}
}
