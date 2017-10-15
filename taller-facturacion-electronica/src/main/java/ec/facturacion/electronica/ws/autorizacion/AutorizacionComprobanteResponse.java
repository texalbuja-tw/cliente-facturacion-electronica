
package ec.facturacion.electronica.ws.autorizacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for autorizacionComprobanteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="autorizacionComprobanteResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaAutorizacionComprobante" type="{http://ec.gob.sri.ws.autorizacion}respuestaComprobante" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autorizacionComprobanteResponse", propOrder = {
    "respuestaAutorizacionComprobante"
})
public class AutorizacionComprobanteResponse {

    @XmlElement(name = "RespuestaAutorizacionComprobante")
    protected RespuestaComprobante respuestaAutorizacionComprobante;

    /**
     * Gets the value of the respuestaAutorizacionComprobante property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaComprobante }
     *     
     */
    public RespuestaComprobante getRespuestaAutorizacionComprobante() {
        return respuestaAutorizacionComprobante;
    }

    /**
     * Sets the value of the respuestaAutorizacionComprobante property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaComprobante }
     *     
     */
    public void setRespuestaAutorizacionComprobante(RespuestaComprobante value) {
        this.respuestaAutorizacionComprobante = value;
    }

}
