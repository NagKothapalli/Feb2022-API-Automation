package parseJsonRespone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;

public class ReadJsonData
{
	@Test
	public void readUserData() throws FileNotFoundException
	{
		Gson gson = new Gson();
		FileReader myfile = new FileReader("APIData/UserData.json");
	   	BufferedReader br = new BufferedReader(myfile);
	   	UserData myData = gson.fromJson(myfile, UserData.class);
	   	System.out.println(myData.FirstName);
	   	System.out.println(myData.LastName);
	   	System.out.println(myData.Phone);
	   	System.out.println(myData.CityName);
	   	System.out.println(myData.PinCode);		   	
	}

}

class UserData
{	
	 String FirstName;
	 String LastName;
	 String CityName;
	 String Phone;
	 String PinCode;
}
