package com.demo.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Connect {

	public String Connect(URL inUrl)
	{
		URLConnection conn;
		InputStream in;
		String body = "";
		try 
		{
			conn = inUrl.openConnection();
			in = conn.getInputStream();
			String encoding = conn.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			body = IOUtils.toString(in, encoding);
//			System.out.println(body);


//			DocumentBuilderFactory docBuilderfactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docBuilderfactory.newDocumentBuilder();
//			Document document = docBuilder.parse(body);
//
//			TransformerFactory transformerFactory= TransformerFactory.newInstance();
//			Transformer xform = transformerFactory.newTransformer();
//
//			xform.transform(new DOMSource(document), new StreamResult(System.out));
			
			
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
}
