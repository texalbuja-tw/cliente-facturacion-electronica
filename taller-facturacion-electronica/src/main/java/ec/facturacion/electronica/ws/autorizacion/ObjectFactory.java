
package ec.facturacion.electronica.ws.autorizacion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.facturacion.electronica.ws.autorizacion package. 
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

    private final static QName _RespuestaAutorizacion_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "RespuestaAutorizacion");
    private final static QName _Autorizacion_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacion");
    private final static QName _AutorizacionComprobante_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobante");
    private final static QName _AutorizacionComprobanteLote_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobanteLote");
    private final static QName _AutorizacionComprobanteLoteResponse_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobanteLoteResponse");
    private final static QName _AutorizacionComprobanteResponse_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobanteResponse");
    private final static QName _Mensaje_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "mensaje");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.facturacion.electronica.ws.autorizacion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RespuestaLote }
     * 
     */
    public RespuestaLote createRespuestaLote() {
        return new RespuestaLote();
    }

    /**
     * Create an instance of {@link RespuestaComprobante }
     * 
     */
    public RespuestaComprobante createRespuestaComprobante() {
        return new RespuestaComprobante();
    }

    /**
     * Create an instance of {@link Autorizacion }
     * 
     */
    public Autorizacion createAutorizacion() {
        return new Autorizacion();
    }

    /**
     * Create an instance of {@link AutorizacionComprobante }
     * 
     */
    public AutorizacionComprobante createAutorizacionComprobante() {
        return new AutorizacionComprobante();
    }

    /**
     * Create an instance of {@link AutorizacionComprobanteLote }
     * 
     */
    public AutorizacionComprobanteLote createAutorizacionComprobanteLote() {
        return new AutorizacionComprobanteLote();
    }

    /**
     * Create an instance of {@link AutorizacionComprobanteLoteResponse }
     * 
     */
    public AutorizacionComprobanteLoteResponse createAutorizacionComprobanteLoteResponse() {
        return new AutorizacionComprobanteLoteResponse();
    }

    /**
     * Create an instance of {@link AutorizacionComprobanteResponse }
     * 
     */
    public AutorizacionComprobanteResponse createAutorizacionComprobanteResponse() {
        return new AutorizacionComprobanteResponse();
    }

    /**
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link RespuestaLote.Autorizaciones }
     * 
     */
    public RespuestaLote.Autorizaciones createRespuestaLoteAutorizaciones() {
        return new RespuestaLote.Autorizaciones();
    }

    /**
     * Create an instance of {@link RespuestaComprobante.Autorizaciones }
     * 
     */
    public RespuestaComprobante.Autorizaciones createRespuestaComprobanteAutorizaciones() {
        return new RespuestaComprobante.Autorizaciones();
    }

    /**
     * Create an instance of {@link Autorizacion.Mensajes }
     * 
     */
    public Autorizacion.Mensajes createAutorizacionMensajes() {
        return new Autorizacion.Mensajes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "RespuestaAutorizacion")
    public JAXBElement<Object> createRespuestaAutorizacion(Object value) {
        return new JAXBElement<Object>(_RespuestaAutorizacion_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autorizacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "autorizacion")
    public JAXBElement<Autorizacion> createAutorizacion(Autorizacion value) {
        return new JAXBElement<Autorizacion>(_Autorizacion_QNAME, Autorizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizacionComprobante }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "autorizacionComprobante")
    public JAXBElement<AutorizacionComprobante> createAutorizacionComprobante(AutorizacionComprobante value) {
        return new JAXBElement<AutorizacionComprobante>(_AutorizacionComprobante_QNAME, AutorizacionComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizacionComprobanteLote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "autorizacionComprobanteLote")
    public JAXBElement<AutorizacionComprobanteLote> createAutorizacionComprobanteLote(AutorizacionComprobanteLote value) {
        return new JAXBElement<AutorizacionComprobanteLote>(_AutorizacionComprobanteLote_QNAME, AutorizacionComprobanteLote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizacionComprobanteLoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "autorizacionComprobanteLoteResponse")
    public JAXBElement<AutorizacionComprobanteLoteResponse> createAutorizacionComprobanteLoteResponse(AutorizacionComprobanteLoteResponse value) {
        return new JAXBElement<AutorizacionComprobanteLoteResponse>(_AutorizacionComprobanteLoteResponse_QNAME, AutorizacionComprobanteLoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizacionComprobanteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "autorizacionComprobanteResponse")
    public JAXBElement<AutorizacionComprobanteResponse> createAutorizacionComprobanteResponse(AutorizacionComprobanteResponse value) {
        return new JAXBElement<AutorizacionComprobanteResponse>(_AutorizacionComprobanteResponse_QNAME, AutorizacionComprobanteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mensaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.gob.sri.ws.autorizacion", name = "mensaje")
    public JAXBElement<Mensaje> createMensaje(Mensaje value) {
        return new JAXBElement<Mensaje>(_Mensaje_QNAME, Mensaje.class, null, value);
    }

}
