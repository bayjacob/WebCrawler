package com.demo;

import java.io.IOException;
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
	
	//This map will contain the step and resulting links
	HashMap<Integer, List<String>> stepMap = new HashMap();
	//This map will contain the page and resulting links
	HashMap<String, List<String>> pageMap = new HashMap();
	//List of all pages for tracking
	List<String> masterList = new ArrayList();
	public static void main(String[] args) throws IOException
	{
//		System.out.println("Hello World");
		URL url = new URL(DOMAIN + START_PAGE);
		Connect start = new Connect();
		Parse parse = new Parse();
		
		//Start by getting first step, and parsing links.
		List<String> links = parse.parseHtml(start.Connect(url));
		
	    //get distinct links that are part of the domain.
	    List<String> domainLinks = links.stream().filter(x->x.contains(DOMAIN)).distinct().collect(Collectors.toList());
	    domainLinks.stream().forEach(x->System.out.println(x));
	    
	    
	}
}
