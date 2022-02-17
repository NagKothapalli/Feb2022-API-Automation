package com.API_Automation;

import org.junit.Test;

public class EnacapsulationTest
{
	Encapsulation ecap = new Encapsulation();
	
	@Test
	public void myTest()
	{
		//System.out.println(ecap.name);
		//ecap.name = "Krishna";
		//System.out.println(ecap.name);
		//System.out.println(ecap.number);
		//ecap.number = 55;
		//System.out.println(ecap.number);
	}
	@Test
	public void encapsulatedData()
	{
		String name = ecap.getName();
		System.out.println("Exisitng Name :" + name);
		ecap.setName("Ravi");
		System.out.println("Name after setting it :" + ecap.getName());
	}

}
