package com.API_Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MealBrite
{
	@Test
	public void addCustomer() throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		FileInputStream myfile = new FileInputStream("APIData/AddCustomer.json");
		httpRequest.body(myfile);
		Response response = httpRequest.request(Method.POST, "/customer/add");//endpoint will be same for all servers/environments
		int code = response.getStatusCode();
		System.out.println("Status code :"+ code);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(200, code);		
		boolean result = responseBody.contains("200055"); 
		Assert.assertTrue(result);		
	}
	@Test
	public void getCustomerProfile() throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		FileInputStream myfile = new FileInputStream("APIData/GetCustomerProfile.json");
		httpRequest.body(myfile);
		Response response = httpRequest.request(Method.POST, "/customer/getCustomerProfile");//endpoint will be same for all servers/environments
		int code = response.getStatusCode();
		System.out.println("Status code :"+ code);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(200, code);		
		boolean result = responseBody.contains("200055"); 
		Assert.assertTrue(result);
		Assert.assertTrue(responseBody.contains("Nag"));
		Assert.assertTrue(responseBody.contains("nag024@gmail.com"));
		Assert.assertTrue(responseBody.contains("\"status\":\"Active\""));
	}

}
