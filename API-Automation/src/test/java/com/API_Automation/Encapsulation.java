package com.API_Automation;

public class Encapsulation
{
	private String name = "Ram";
	private int number = 22;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		System.out.println("Log - Someone updated Name");
		this.name = newName;
	}

}
