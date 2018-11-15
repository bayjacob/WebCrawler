package com.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.connect.Connect;
import com.demo.exceptions.DemoExeception;
import com.demo.parse.Parse;

public class Dive 
{
	public void urlDive (List<String> urls)
	{
		urls.stream().forEach(s -> 
	    {
	    	if(!Main.masterList.contains(s))
	    	{
	    		Main.masterList.add(s);
	    		try 
	    		{
	    			Parse parse = new Parse();
	    			Connect connect = new Connect();
					List<String> pagelinks = parse.parseHtml(connect.connectToURL(new URL(s))).stream().filter(x->x.contains(Main.DOMAIN)).distinct().collect(Collectors.toList());
				    Main.pageMap.put(s, pagelinks);
				}
	    		catch (MalformedURLException e) 
	    		{
					e.printStackTrace();
				}
	    		catch (DemoExeception e) 
	    		{
					e.printStackTrace();
				}
	    	}
	    });
	}
}
