package com.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.connect.Connect;
import com.demo.parse.Parse;

public class Main {
	
	private static final String DOMAIN = "https://wiprodigital.com";
	private static final String START_PAGE = "/";
	
	//This map will contain the page and resulting links
	static HashMap<String, List<String>> pageMap = new HashMap<String, List<String>>();
	//List of all pages for tracking
	static List<String> masterList = new ArrayList<String>();
	public static void main(String[] args) throws IOException
	{
		Integer step = 0;
//		System.out.println("Hello World");
		URL url = new URL(DOMAIN + START_PAGE);
		Connect start = new Connect();
		Parse parse = new Parse();
		
		//Start by getting first step, and parsing links.
		List<String> links = parse.parseHtml(start.Connect(url));
		
	    //get distinct links that are part of the domain.
	    List<String> domainLinks = links.stream().filter(x->x.contains(DOMAIN)).distinct().collect(Collectors.toList());
//	    domainLinks.stream().forEach(x->System.out.println(x));
	
	    //add to tracking maps
	    pageMap.put(START_PAGE, domainLinks);
	    step = step + 1;
	    
//	    System.out.println("-----------------------------------");
	    domainLinks.stream().forEach(s -> {
	    	if(!masterList.contains(s))
	    	{
	    		masterList.add(s);
	    		try 
	    		{
					List<String> pagelinks = parse.parseHtml(start.Connect(new URL(s))).stream().filter(x->x.contains(DOMAIN)).distinct().collect(Collectors.toList());
				    pageMap.put(s, pagelinks);
//					pagelinks.stream().forEach(x->System.out.println(x));
//					System.out.println("-----------------------------------");
				}
	    		catch (MalformedURLException e) 
	    		{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		catch (IOException e) 
	    		{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    });
	    
	    if(false);
	    pageMap.forEach((k,v)->{
	    	System.out.println(k);
	    	v.forEach(s->
	    	{
	    		System.out.println("\t" + s);
	    	});
	    });
	}
}
