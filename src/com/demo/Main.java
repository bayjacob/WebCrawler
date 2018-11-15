package com.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.demo.connect.Connect;
import com.demo.exceptions.DemoExeception;
import com.demo.parse.Parse;

public class Main {
	
	static final String DOMAIN = "https://wiprodigital.com";
	private static final String START_PAGE = "/";
	
	//This map will contain the page and resulting links
	static ConcurrentHashMap<String, List<String>> pageMap = new ConcurrentHashMap<String, List<String>>();
	//List of all pages for tracking
	static List<String> masterList = Collections.synchronizedList(new ArrayList<String>());
	public static void main(String[] args) throws DemoExeception
	{
		Integer step = 0;
		URL url;
		try 
		{
			url = new URL(DOMAIN + START_PAGE);
		}
		catch (MalformedURLException e2) 
		{
			throw new DemoExeception(e2.getMessage());
		}
		
		Connect start = new Connect();
		Parse parse = new Parse();
		
		//Start by getting first step, and parsing links.
		List<String> links = new ArrayList();
		links = parse.parseHtml(start.connectToURL(url));
		
	    //get distinct links that are part of the domain.
	    List<String> domainLinks = links.stream().filter(x->x.contains(DOMAIN)).distinct().collect(Collectors.toList());
	
	    //add to tracking maps
	    pageMap.put(START_PAGE, domainLinks);
	    
	    step = step + 1;
	    
	    //---------------Start Dive-------------//
	    
	    Dive firstDive = new Dive();
	    firstDive.urlDive(domainLinks);
	    
	    //----------------End Dive----------------//
	    
	    //----------------Print------------------//
	    pageMap.forEach((k,v)->
	    {
	    	System.out.println(k);
	    	v.forEach(s->
	    	{
	    		System.out.println("\t" + s);
	    	});
	    });
	}
}
