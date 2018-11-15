package com.demo;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.demo.exceptions.DemoExeception;

public class Main {
	
//	public static String DOMAIN = "https://wiprodigital.com/";
	public static String DOMAIN = "https://aol.com/"; //lots of broken links
//	public static String DOMAIN = "https://directcolorado.org/";

	//This map will contain the page and resulting links
	public static ConcurrentHashMap<String, List<String>> pageMap = new ConcurrentHashMap<String, List<String>>();
	//List of all pages for tracking
	public static List<String> masterList = Collections.synchronizedList(new ArrayList<String>());
	
	public static void main(String[] args) throws DemoExeception, MalformedURLException
	{
	    //---------------Start Dive-------------//
	    new Dive(Arrays.asList(DOMAIN)).run();
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
