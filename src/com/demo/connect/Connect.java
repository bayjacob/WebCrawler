package com.demo.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.demo.exceptions.DemoExeception;

public class Connect {

	public String connectToURL(URL inUrl) throws DemoExeception {
		URLConnection conn;
		InputStream in;
		String body = "";
		try {
			conn = inUrl.openConnection();
			in = conn.getInputStream();
			String encoding = conn.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			body = IOUtils.toString(in, encoding);
		} 
		catch (IOException e) 
		{
			throw new DemoExeception(e.getMessage());
		}
		return body;
	}
}
