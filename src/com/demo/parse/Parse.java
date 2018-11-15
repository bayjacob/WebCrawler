package com.demo.parse;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import com.demo.exceptions.DemoExeception;

public class Parse {

	public List<String> parseHtml(String body) throws DemoExeception
	{
		Reader reader = new StringReader(body);
		HTMLEditorKit.Parser parser = new ParserDelegator();
	    final List<String> links = new ArrayList<String>();
	    
	    try 
	    {
			parser.parse(reader, new HTMLEditorKit.ParserCallback()
			{
			       public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) 
			       {
			           if(t == HTML.Tag.A) 
			           {
			               Object link = a.getAttribute(HTML.Attribute.HREF);
			               if(link != null) 
			               {
			                   links.add(String.valueOf(link));
			               }
			           }
			       }
			}, true);
		} 
	    catch (IOException e) {
			throw new DemoExeception(e.getMessage());
		}
	    
	   return links;
	}
}
