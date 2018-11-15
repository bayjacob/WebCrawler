package com.demo.dive;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.demo.Dive;

class DiveTest {

	@Test
	void test() 
	{
		
		Dive sut = new Dive(Arrays.asList("abc")) {
			@Override
			public boolean doRecursion()
			{
				return false;
			}
		};
	}

}
