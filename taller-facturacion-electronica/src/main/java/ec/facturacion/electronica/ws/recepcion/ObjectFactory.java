
package ec.facturacion.electronica.ws.recepcion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.facturacion.electronica.ws.recepcion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RespuestaSolicitud_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "RespuestaSolicitud");
    private final static QName _Comprobante_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "comprobante");
    private final static QName _Mensaje_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "mensaje");
    private final static QName _ValidarComprobante_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "validarComprobante");
    private final static QName _ValidarComprobanteResponse_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "validarComprobanteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.facturacion.electronica.ws.recepcion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Comprobante }
     * 
     */
    public Comprobante createComprobante() {
        return new Comprobante();
    }

    /**
     * Create an instance of {@link RespuestaSolicitud }
     * 
     */
    public RespuestaSolicitud createRespuestaSolicitud() {
        return new RespuestaSolicitud();
    }

    /**
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link ValidarComprobante }
     * 
     */
    public ValidarComprobante createValidarComprobante() {
        return new ValidarComprobante();
    }

    /**
     * Create an instance of {@link ValidarComprobanteResponse }
     * 
     */
    public ValidarComprobanteResponse createValidarComprobanteResponse() {
        return new ValidarComprobanteResponse();
    }

    /**
     * Create an instance of {@link Comprobante.Mensajes }
     * 
     */
    public Comprobante.Mensajes createComprobanteMensajes() {
        return new Comprobante.Mensajes();
    }

    /**
     * Create an instance of {@link RespuestaSolicitud.Comprobantes }
     * 
     */
    public RespuestaSolicitud.Comprobantes createRespuestaSolicitudComprobantes() {
        return new RespuestaSolicitud.Comprobantes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaSolicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.recepcion", name = "RespuestaSolicitud")
    public JAXBElement<RespuestaSolicitud> createRespuestaSolicitud(RespuestaSolicitud value) {
        return new JAXBElement<RespuestaSolicitud>(_RespuestaSolicitud_QNAME, RespuestaSolicitud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comprobante }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.recepcion", name = "comprobante")
    public JAXBElement<Comprobante> createComprobante(Comprobante value) {
        return new JAXBElement<Comprobante>(_Comprobante_QNAME, Comprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mensaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.recepcion", name = "mensaje")
    public JAXBElement<Mensaje> createMensaje(Mensaje value) {
        return new JAXBElement<Mensaje>(_Mensaje_QNAME, Mensaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarComprobante }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.recepcion", name = "validarComprobante")
    public JAXBElement<ValidarComprobante> createValidarComprobante(ValidarComprobante value) {
        return new JAXBElement<ValidarComprobante>(_ValidarComprobante_QNAME, ValidarComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarComprobanteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.recepcion", name = "validarComprobanteResponse")
    public JAXBElement<ValidarComprobanteResponse> createValidarComprobanteResponse(ValidarComprobanteResponse value) {
        return new JAXBElement<ValidarComprobanteResponse>(_ValidarComprobanteResponse_QNAME, ValidarComprobanteResponse.class, null, value);
    }

}
