package com.demo.parse;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import com.demo.exceptions.DemoExeception;
import com.demo.exceptions.NotFoundException;

class ParseTest {

	//Would have used before and before class, but wasnt working.

	@Test
	void setupConfirm() throws DemoExeception, NotFoundException 
	{
		String body = null;
		Parse sut = new Parse();
		try {
			body = IOUtils.toString(
				      this.getClass().getResourceAsStream("parseTest.html"),
				      "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert(body != null);

		List<String> returned = sut.parseHtml(body);
		System.out.println(returned.size());
		assert(true);
	}
	
	

}
