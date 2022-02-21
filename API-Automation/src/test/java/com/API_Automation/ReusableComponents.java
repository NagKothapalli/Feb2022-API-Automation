package com.API_Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Assert;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReusableComponents
{
	
	public boolean validateCustomerStatus(String expectedStatus) throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		FileInputStream myfile = new FileInputStream("APIData/GetCustomerProfile.json");
		httpRequest.body(myfile);
		Response response = httpRequest.request(Method.POST, "/customer/getCustomerProfile");//endpoint will be same for all servers/environments
		String responseBody = response.getBody().asString();
		System.out.println("responseBody :" + responseBody);
		Customer root2 = gson.fromJson(response.getBody().asString(), Customer.class);
		//Assert.assertTrue("Status of the Customer is not ACTIVE",responseBody.contains("\"status\":\""+expectedStatus+"\""));
		return responseBody.contains("\"status\":\""+expectedStatus+"\"");
	}
	Gson gson = new Gson();
	public boolean addCustomer() throws FileNotFoundException
	{
		Gson gson = new Gson();
		FileReader myfile = new FileReader("APIData/AddCustomer.json");
		Customer root = gson.fromJson(myfile, Customer.class);
		root.firstName = "YashaSree";
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Same for all end points , but different for different servers like Dev, Qa , stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		//FileInputStream myfile1 = new FileInputStream("APIData/AddCustomer.json");
		httpRequest.body(gson.toJson(root).toString());
		Response response = httpRequest.request(Method.POST, "/customer/add");//endpoint will be same for all servers/environments
		Customer root2 = gson.fromJson(response.getBody().asString(), Customer.class);
		System.out.println("My Response Body :" + response.getBody().asString());
		System.out.println("My Response Code :" + response.getStatusCode());
		return (response.getStatusCode() == 200  ); // relational 	
	}
}
class Customer{
	 public String customerId;
	 public String firstName;
	 public String lastName;
	 public String addressLine1;
	 public String addressLine2;
	 public String city;
	 public String state;
	 public int zip;
	 public String countryCode;
	 public String phone;
	 public String email;
	 public String status;
	 public String activationDate;
	 public String userName;
	 public String password;
	 public String createdBy;
	 public String createdAt;
	 public String modifiedBy;
	 public String modifiedAt;
	 public double longitude;
	 public double latitude;
}
