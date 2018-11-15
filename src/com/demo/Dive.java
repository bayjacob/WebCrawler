package com.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.connect.Connect;
import com.demo.exceptions.DemoExeception;
import com.demo.exceptions.NotFoundException;
import com.demo.parse.Parse;

public class Dive implements Runnable
{
	List<String> urls;
	public Dive (List<String> urls)
	{
		this.urls = urls;
	}

	@Override
	public void run() 
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
	    			String body;
	    			if(!s.startsWith("http"))
	    				body = connect.connectToURL(new URL(Main.DOMAIN + s));
	    			else
	    				body = connect.connectToURL(new URL(s));
	    			
					List<String> pageLinks = parse.parseHtml(body)
							.stream()
							.filter(x->(x.contains(Main.DOMAIN) || !x.startsWith("http")))
							.distinct()
							.collect(Collectors.toList());

					System.out.println(s + ":" + pageLinks.size());
				    Main.pageMap.put(s, pageLinks);
				    new Dive(pageLinks).run();
				}
	    		catch (MalformedURLException e) 
	    		{
	    			System.out.println("Bad URL found while diving:" + e.getMessage());
	    			 return;
				}
	    		catch (NotFoundException e) 
	    		{
	    			System.out.println("404 found while diving:" + e.getMessage());
	    			 return;
				}
	    		catch (DemoExeception e) 
	    		{
	    			System.out.println("Demo Exception while diving: " + e.getMessage());
	    			 return;
				}
	    	}
	    });
		
	}
}
