package com.nubuteam.test;

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

public class XmlTest {

	@SuppressWarnings("rawtypes")
	public static Boolean validaQueUnaClaseCumplaConUnXSD(Class xmlClass, Object object, String schemaFileName)
			throws SAXException, IOException, JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File xmlResult = File.createTempFile(xmlClass.getName(), ".xml");
			jaxbMarshaller.marshal(object, xmlResult);
			jaxbMarshaller.marshal(object, System.out);

			Source xmlFile = new StreamSource(xmlResult);
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaFile = new File("src/test/resources/" + schemaFileName);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
		} catch (SAXParseException ex) {
			ex.printStackTrace();
			return false;
		}
		System.out.println("Es válido");
		return true;
	}
}
