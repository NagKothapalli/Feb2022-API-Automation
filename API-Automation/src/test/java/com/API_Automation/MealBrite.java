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
//              child             parent
public class MealBrite extends ReusableComponents
{
	//AddCustomerAndGetCustomerProfile
	@Test
	public void addCustomerAndGetCustomerProfile() throws FileNotFoundException
	{
		boolean result = addCustomer();
		if(result)
		{
			validateCustomerStatus("Active");  // HashMap - key value : fn : nag , ln : K , status:Active
		    //validateCustomerStatus("Active");
		}
		else
		{
			System.out.println("Customer Validation Failed");			
			System.out.println("This is a part of else case");
		}		
			
	}
	@Test
	public void addNewCustomer() throws FileNotFoundException
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
		boolean result = responseBody.contains("200056"); 
		Assert.assertTrue(result);	
		validateCustomerStatus("Active");
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
		Assert.assertTrue("Status of the Customer is not ACTIVE",responseBody.contains("\"status\":\"Active\""));
		Assert.assertTrue("UserName of the Customer is not Correct",responseBody.contains("\"userName\":\"NagKothapalli\""));
		Assert.assertTrue("Password of the Customer is not Correct",responseBody.contains("\"password\":\"test123\""));
	}
	@Test
	public void updateCustomer() throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		FileInputStream myfile = new FileInputStream("APIData/UpdateCustomer.json");
		httpRequest.body(myfile);
		Response response = httpRequest.request(Method.POST, "/customer/update");//endpoint will be same for all servers/environments
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("Status code :"+ response.getStatusCode());
		System.out.println("Response Body is =>  " + response.getBody().asString());
		Assert.assertTrue(response.getBody().asString().contains("200055"));		
	}
	@Test
	public void deleteCustomer() throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		FileInputStream myfile = new FileInputStream("APIData/GetCustomerProfile.json");
		httpRequest.body(myfile);
		Response response = httpRequest.request(Method.POST, "/customer/delete");//endpoint will be same for all servers/environments
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("Status code :"+ response.getStatusCode());
		System.out.println("Response Body is =>  " + response.getBody().asString());
		Assert.assertTrue("Employee ID is not correct : ",response.getBody().asString().contains("200056"));
		validateCustomerStatus("Archive");
	}

}
