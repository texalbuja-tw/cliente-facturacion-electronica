package com.nubuteam.util;

import java.io.File;
import java.io.IOException;

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

	public static File convertirObjetoAXml(Class xmlClass, Object object)
			throws SAXException, IOException, JAXBException, SAXParseException {

		JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		File xmlResult = File.createTempFile(xmlClass.getName(), ".xml");
		jaxbMarshaller.marshal(object, xmlResult);
		jaxbMarshaller.marshal(object, System.out);
		return xmlResult;

	}

	public static Boolean validarQueUnXmlCumpleConXSD(File xmlFile, String xsdPath)
			throws SAXException, IOException, JAXBException, SAXParseException {
		Source xmlSource = new StreamSource(xmlFile);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		File xsdFile = new File(xsdPath);
		Schema schema = schemaFactory.newSchema(xsdFile);
		Validator validator = schema.newValidator();
		validator.validate(xmlSource);

		return true;
	}
}
