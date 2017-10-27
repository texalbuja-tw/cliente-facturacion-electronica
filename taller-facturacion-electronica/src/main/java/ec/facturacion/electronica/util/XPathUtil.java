package ec.facturacion.electronica.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathUtil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7960395024372637176L;
	/**
	 * 
	 */

	private String criterio;
	private Node documento;

	private final XPathFactory xFactory;
	private final XPath xpath;
	private XPathExpression expresion;
	private static final String FORMATO_FECHA = "dd/MM/yyyy";

	/**
	 * Construye una instancia del utilitario lista para configurar.
	 */
	public XPathUtil() {
		this(null);
	}

	/**
	 * Construye una instancia del utilitario configurada.
	 * 
	 * @param xml
	 */
	public XPathUtil(final Node xml) {
		this.documento = xml;
		xFactory = XPathFactory.newInstance();
		xpath = xFactory.newXPath();
	}

	/**
	 * Construye una instancia del utilitario configurada.
	 * 
	 * @param xml
	 * @param contexto
	 */
	public XPathUtil(final Node xml, final NamespaceContext contexto) {
		this();
		this.documento = xml;
		xpath.setNamespaceContext(contexto);
	}

	/**
	 * Construye una instancia del utilitario configurada.
	 * 
	 * @param criterio
	 *            es el camino para encontrar el nodo.
	 * @param documento
	 *            el documento donde se realiza la consulta.
	 */
	public XPathUtil(final String criterio, final Node xml) {
		this();
		this.criterio = criterio;
		this.documento = xml;
	}

	/**
	 * @return el nodo resultante de evaluar el criterio sobre el documento.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public Node getNodo() throws XPathExpressionException {
		compilar();
		return (Node) evaluar(XPathConstants.NODE);
	}

	/**
	 * @return la lista de nodos resultante de evaluar el criterio sobre el
	 *         documento.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public NodeList getNodos() throws XPathExpressionException {
		compilar();
		return (NodeList) evaluar(XPathConstants.NODESET);
	}

	/**
	 * @return la lista de nodos resultante de evaluar el criterio sobre el
	 *         documento.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public NodeList getNodos(final String criterio) throws XPathExpressionException {
		setCriterio(criterio);
		return getNodos();
	}

	/**
	 * @return el valor numerico resultante de evaluar el criterio sobre el
	 *         documento.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public Number getValorNumerico() throws XPathExpressionException {
		compilar();
		return (Number) evaluar(XPathConstants.NUMBER);
	}

	public Number getValorNumerico(final String criterio) throws XPathExpressionException {
		setCriterio(criterio);
		return getValorNumerico();
	}

	/**
	 * @return el texto contenido en el nodo resultante de evaluar el criterio
	 *         sobre el documento.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public String getTextoNodo() throws XPathExpressionException {
		compilar();
		return (String) evaluar(XPathConstants.STRING);
	}

	/**
	 * @return el texto contenido en el nodo resultante de evaluar el criterio
	 *         sobre el documento.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public String getTextoNodo(final String criterio) throws XPathExpressionException {
		setCriterio(criterio);
		compilar();
		return (String) evaluar(XPathConstants.STRING);
	}

	public Date getFechaNodo(final String criterio) throws XPathExpressionException, ParseException {
		setCriterio(criterio);
		compilar();
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_FECHA);
		return simpleDateFormat.parse((String) evaluar(XPathConstants.STRING));
	}

	/**
	 * @return {@link Boolean#TRUE} si el criterio fue evaluado como verdadero.
	 * @throws XPathExpressionException
	 *             si no es posible compilar el criterio o si no es posible
	 *             evaluarlo sobre el documento.
	 */
	public boolean isVerdadero() throws XPathExpressionException {
		compilar();
		return (Boolean) evaluar(XPathConstants.BOOLEAN);
	}

	private void compilar() throws XPathExpressionException {
		if (null == criterio || criterio.isEmpty()) {
			throw new IllegalStateException("El criterio de consulta para compilar es nula");
		}
		expresion = xpath.compile(criterio);
	}

	private Object evaluar(final QName qName) throws XPathExpressionException {
		if (null == documento) {
			throw new IllegalStateException("El documento donde se consultara el criterio es nulo");
		}
		return expresion.evaluate(documento, qName);
	}

	public boolean existeNodo(final String criterio) throws XPathExpressionException {
		Node node = (Node) xpath.evaluate(criterio, documento, XPathConstants.NODE);
		return node == null;

	}

	/**
	 * @return el criterio de busqueda con el que esta configurado.
	 */
	public String getCriterio() {
		return criterio;
	}

	/**
	 * @param criterio
	 *            es el camino para encontrar el nodo.
	 */
	public void setCriterio(String path) {
		this.criterio = path;
	}

	/**
	 * @return el documento configurado donde se realiza la consulta.
	 */
	public Node getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            es el documento o pedazo de documento donde se va a consultar
	 *            el criterio.
	 */
	public void setDocumento(final Node xml) {
		this.documento = xml;
	}

}
