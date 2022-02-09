package com.API_Automation;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Calls
{
	@Test
	public void getUsersList()
	 {
		RestAssured.baseURI = "https://reqres.in";  
		RequestSpecification httpRequest = RestAssured.given();
		//httpRequest.body("{\"category\":\"restaurantFood\",\"searchStrings\":[\"chicken\"]}");
		//httpRequest.contentType(ContentType.JSON);
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		int code = response.getStatusCode();
		System.out.println("Status code :"+ code);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(200, code);		
		boolean result = responseBody.contains("\"total_pages\":4"); //Escape character
		Assert.assertTrue(result);
	 }
	@Test
	public void createUser()
	 {
		RestAssured.baseURI = "https://reqres.in";  
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.body("{\"name\": \"Nag\", \"job\": \"leader\"}");
		httpRequest.contentType(ContentType.JSON);
		Response response = httpRequest.request(Method.POST, "/api/users");
		int code = response.getStatusCode();
		System.out.println("Status code :"+ code);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(201, code);		
		boolean result = responseBody.contains("Nag"); 
		Assert.assertTrue(result);
	 }
	@Test
	public void updateUser()
	 {
		RestAssured.baseURI = "https://reqres.in";  
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.body("{\"name\": \"Nag\", \"job\": \"Sr Leader\"}");
		httpRequest.contentType(ContentType.JSON);
		Response response = httpRequest.request(Method.PUT, "/api/users/2");
		int code = response.getStatusCode();
		System.out.println("Status code :"+ code);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals("Response Code is not correct",200, code);		
		boolean result = responseBody.contains("Sr Leader"); 
		Assert.assertTrue(result);
	 }
	@Test
	public void deleteUser()
	 {
		RestAssured.baseURI = "https://reqres.in";  
		RequestSpecification httpRequest = RestAssured.given();
		//httpRequest.body("{\"name\": \"Nag\", \"job\": \"Sr Leader\"}");
		//httpRequest.contentType(ContentType.JSON);
		Response response = httpRequest.request(Method.DELETE, "/api/users/2");
		int code = response.getStatusCode();
		System.out.println("Status code :"+ code);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals("Response Code is not correct",204, code);		
	 }
	

}
