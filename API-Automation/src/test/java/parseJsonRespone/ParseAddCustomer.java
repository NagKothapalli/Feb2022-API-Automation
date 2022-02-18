package parseJsonRespone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;

public class ParseAddCustomer
{
	@Test
	public void readCustomerData() throws FileNotFoundException
	{
		Gson gson = new Gson();
		FileReader myfile = new FileReader("APIData/AddCustomer.json");
		Customer root = gson.fromJson(myfile, Customer.class);
		//System.out.println("my city name :" + root.CityName);
		System.out.println("my Customer ID :" + root.customerId);
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


