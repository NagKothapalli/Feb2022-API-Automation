package parseJsonRespone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.Gson;

public class ReadHotelData
{
	Gson gson = new Gson();
	@Test
	public void hotelInformation() throws FileNotFoundException
	{
		FileReader myfile = new FileReader("APIData/Hotel.json");
		Root root = gson.fromJson(myfile, Root.class); //DeSerialization
		System.out.println(root.Resuarent);
		System.out.println(root.Address);
		for(int i=0;i<root.primaryProducts.size();i++)
		{
			System.out.println("Product Details **************");
			System.out.println(root.primaryProducts.get(i).productCategory);
			System.out.println(root.primaryProducts.get(i).productName);
			System.out.println(root.primaryProducts.get(i).productPrice);
			for(int j=0;j<root.primaryProducts.get(i).productPrice.size();j++)
			{
				System.out.println("***********Product Price ************************");
				System.out.println(root.primaryProducts.get(i).productPrice.get(j).CakeType);
				System.out.println(root.primaryProducts.get(i).productPrice.get(j).Price);
			}
			System.out.println(root.primaryProducts.get(i).productType);
			System.out.println(root.primaryProducts.get(i).taxPercentage);
		}
		for(int i=0;i<root.primaryProducts.size();i++)
		{
			System.out.println("Secondary Product Details **************");
			System.out.println(root.secondaryProducts.get(i).productName);
			System.out.println(root.secondaryProducts.get(i).productPrice);
			
		}
	}

}
//Root root = om.readValue(myJsonString, Root.class); */
class Root{
	 public String Resuarent;
	 public String Address;
	 public ArrayList<PrimaryProduct> primaryProducts;
	 public ArrayList<SecondaryProduct> secondaryProducts;
	}
class ProductPrice{
 public String CakeType;
 public int Price;
}

class PrimaryProduct{
 public String productName;
 public ArrayList<ProductPrice> productPrice;
 public double taxPercentage;
 public String productCategory;
 public String productType;
}

class SecondaryProduct{
 public String productName;
 public int productPrice;
}









