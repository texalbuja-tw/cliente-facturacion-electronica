package ec.facturacion.electronica.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlUtil {

	public static ByteArrayOutputStream convertirObjetoAXml(Class xmlClass, Object object)
			throws SAXException, IOException, JAXBException, SAXParseException {

		JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		jaxbMarshaller.marshal(object, baos);
		return baos;

	}

	public static Boolean validarQueUnXmlCumpleConXSD(InputStream xmlInpuStream, String xsdPath)
			throws SAXException, IOException, JAXBException, SAXParseException {
		Source xmlSource = new StreamSource(xmlInpuStream);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		File xsdFile = new File(xsdPath);
		Schema schema = schemaFactory.newSchema(xsdFile);
		Validator validator = schema.newValidator();
		validator.validate(xmlSource);

		return true;
	}
}
