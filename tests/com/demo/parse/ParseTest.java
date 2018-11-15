package com.demo.parse;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.exceptions.DemoExeception;
import com.demo.exceptions.NotFoundException;

public class ParseTest 
{
	static String body;
	Parse sut;
	
	@BeforeClass
	public static void LoadFile()
	{
		try 
		{
			body = IOUtils.toString(
				      ParseTest.class.getResourceAsStream("parseTest.html"),
				      "UTF-8");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Before
	public void setup()
	{
		sut = new Parse();
	}
	
	@Test
	public void setupConfirm() 
	{
		assert(ParseTest.body != null);
	}
	
	@Test
	public void parse() throws DemoExeception, NotFoundException 
	{
		sut.parseHtml(ParseTest.body);
	}
	
	@Test
	public void linkTest() throws DemoExeception, NotFoundException 
	{
		List<String> returned = sut.parseHtml(ParseTest.body);
		assert(returned.size() == 12);
	}
}
