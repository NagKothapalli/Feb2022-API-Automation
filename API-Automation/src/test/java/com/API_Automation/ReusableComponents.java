package com.API_Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReusableComponents
{
	
	public void validateCustomerStatus(String expectedStatus) throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		FileInputStream myfile = new FileInputStream("APIData/GetCustomerProfile.json");
		httpRequest.body(myfile);
		Response response = httpRequest.request(Method.POST, "/customer/getCustomerProfile");//endpoint will be same for all servers/environments
		String responseBody = response.getBody().asString();
		System.out.println("responseBody :" + responseBody);
		Assert.assertTrue("Status of the Customer is not ACTIVE",responseBody.contains("\"status\":\""+expectedStatus+"\""));
	}
}
