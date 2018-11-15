package com.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.demo.connect.Connect;
import com.demo.exceptions.DemoExeception;
import com.demo.parse.Parse;

public class Main {
	
	static final String DOMAIN = "https://wiprodigital.com/";
	
	//This map will contain the page and resulting links
	static ConcurrentHashMap<String, List<String>> pageMap = new ConcurrentHashMap<String, List<String>>();
	//List of all pages for tracking
	static List<String> masterList = Collections.synchronizedList(new ArrayList<String>());
	
	public static void main(String[] args) throws DemoExeception, MalformedURLException
	{
	    //---------------Start Dive-------------//
	    Dive firstDive = new Dive();
	    firstDive.urlDive(Arrays.asList(DOMAIN));
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
