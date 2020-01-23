package InternshipTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//Input output class for method reading from file, printing content to console
public class IO {
	//Print method, prints formatted table from list
	//Parameters - list, title of the table
	public static void Print(List<Product> list, String title) {
		String line = "-------------------------------";
		System.out.println(line);
		System.out.println(title);
		System.out.println(line);
		
		if(list.isEmpty())
			System.out.println("There were no products with these paremeters");
		else
		{
			System.out.println(String.format("|%-20s|%-20s|%-10s|%15s|", "Name", "Code", "Quantity", "Expiration Date"));
			for(Product product:list) {
				System.out.println(product.toString());
    		}
		}
		System.out.println(line);
	}
	
	//Method that read from file
	//Gets file in Data directory by the name
	//Add products to the container
	public static void Read(ProductContainer cont, String fileName) throws FileNotFoundException, ParseException {
		File file = Paths.get("Data", fileName).toFile();
	    Scanner sc = new Scanner(file);
	    sc.nextLine(); //First line skip
	    
	    while (sc.hasNextLine()) 	
	    {
	    	String[] lineElements = sc.nextLine().split(",");
	    	long code = Long.parseLong(lineElements[1]);
	    	int quantity = Integer.parseInt(lineElements[2]);
	    	Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(lineElements[3]);  
	    	Product prod = new Product(lineElements[0], code, expirationDate, quantity);
	    	cont.addProduct(prod);
	    }
	    sc.close();
	}
}
