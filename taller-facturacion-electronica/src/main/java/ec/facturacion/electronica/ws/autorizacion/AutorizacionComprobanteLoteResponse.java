
package ec.facturacion.electronica.ws.autorizacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for autorizacionComprobanteLoteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="autorizacionComprobanteLoteResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RespuestaAutorizacionLote" type="{http://ec.gob.sri.ws.autorizacion}respuestaLote" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autorizacionComprobanteLoteResponse", propOrder = {
    "respuestaAutorizacionLote"
})
public class AutorizacionComprobanteLoteResponse {

    @XmlElement(name = "RespuestaAutorizacionLote")
    protected RespuestaLote respuestaAutorizacionLote;

    /**
     * Gets the value of the respuestaAutorizacionLote property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaLote }
     *     
     */
    public RespuestaLote getRespuestaAutorizacionLote() {
        return respuestaAutorizacionLote;
    }

    /**
     * Sets the value of the respuestaAutorizacionLote property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaLote }
     *     
     */
    public void setRespuestaAutorizacionLote(RespuestaLote value) {
        this.respuestaAutorizacionLote = value;
    }

}
