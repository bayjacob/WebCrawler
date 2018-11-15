package com.demo.connect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.demo.exceptions.DemoExeception;
import com.demo.exceptions.NotFoundException;

public class Connect {

	public String connectToURL(URL inUrl) throws DemoExeception, NotFoundException 
	{
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
		catch (FileNotFoundException e) 
	    {
			throw new NotFoundException(e.getMessage());
		}
	    catch(IOException e)
	    {
	    	throw new DemoExeception(e.getMessage());
	    }
		return body;
	}
}
