package parseJsonRespone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import org.junit.Test;

import com.google.gson.Gson;

public class ParseAddCustomer
{
	Gson gson = new Gson();
	/*
	 * int id = 200056; Random random = new Random(); int ran = random.nextInt(99);
	 * id = id+ran; String nid = Integer.toString(id); root.customerId = nid;
	 */
	@Test
	public void readCustomerData() throws FileNotFoundException
	{
		//Read the payload from json file and parse it in to a java object .
		//And do the required changes to the java object and save the java object for future validations
		//Now convert that java object in to a json string 
		//Then this json string can be passed as payload to the End Point
		//Again take the response from the end point in to a java object . To do the required validations		
		FileReader myfile = new FileReader("APIData/AddCustomer.json");
		Customer root1 = gson.fromJson(myfile, Customer.class); //DeSerialization
		String mypayloadbefore = gson.toJson(root1);
		System.out.println("My  payload before :" + mypayloadbefore);
		System.out.println("My Customer ID before modify :" + root1.customerId);
		root1.customerId = Integer.toString(200056 + new Random().nextInt(99));
		root1.firstName = "Ram";
		root1.phone = "9959775758";
		String mypayloadafter = gson.toJson(root1); //Serialization - To transfer the data over the network easily in light weight form
		System.out.println("My  new payload :" + mypayloadafter);
		//Give the above json string as bodu to the end point
		//After we will get Response 
		
		
		//System.out.println("my city name :" + root.CityName);
		System.out.println("my Customer ID :" + root1.customerId);
		/*
		 * System.out.println(myCustomer.customerId);
		 * System.out.println(myCustomer.phone); System.out.println(myCustomer.email);
		 */
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


