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

}
