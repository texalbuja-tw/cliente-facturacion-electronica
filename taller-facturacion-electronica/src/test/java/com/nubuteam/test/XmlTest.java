package com.nubuteam.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlTest {
	@Test
	public void deberiaProbarQueUnXmlEsValido() throws SAXException, IOException {

		URL schemaFile;
		Source xmlFile;

		schemaFile = new URL("http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");

		// or File schemaFile = new File("/location/to/xsd") etc.
		xmlFile = new StreamSource(new File("web.xml"));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		validator.validate(xmlFile);
		System.out.println(xmlFile.getSystemId() + " is valid");

	}

}
