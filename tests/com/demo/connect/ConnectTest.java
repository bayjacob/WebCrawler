package com.demo.connect;

import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import com.demo.exceptions.DemoExeception;
import com.demo.exceptions.NotFoundException;

public class ConnectTest {

	@Test(expected = NotFoundException.class) 
	public void test404() throws MalformedURLException, DemoExeception, NotFoundException 
	{
		Connect sut = new Connect();
		sut.connectToURL(new URL("https://www.aol.com/forgot/"));
		fail("Exception should be thrown");
	}
}
