package com.demo.dive;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.demo.Dive;
import com.demo.Main;

public class DiveTest {

	@Before
	public void setup()
	{
		Main.DOMAIN = "https://directcolorado.org/";
	}
	
	@Test
	public void failtest() 
	{
		
		Dive sut = new Dive(Arrays.asList("abc")) {
			@Override
			public boolean doRecursion()
			{
				return false;
			}
		};
		
		new Thread(sut).run();
		
		Main.masterList.size();
	}
	
	@Test
	public void test() 
	{
		
		Dive sut = new Dive(Arrays.asList("")) {
			@Override
			public boolean doRecursion()
			{
				return false;
			}
		};
		
		new Thread(sut).run();
		assert(Main.masterList.size() == 1);
		assert(Main.pageMap.keySet().size() == 1);
		assert(Main.pageMap.get("").size() == 7);
	}

}
