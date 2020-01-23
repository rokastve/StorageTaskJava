package InternshipTask;

import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat; 

public class Main {
	private static boolean running = true;
	private static Scanner myObj;
	private static ProductContainer cont = new ProductContainer();
	public static void main(String args[]) throws Exception  
    {  
		myObj = new Scanner(System.in);
		boolean correctFile = false;
		while(!correctFile) {
		System.out.println("Enter file name (without .csv, for example: sample)");
	    String file = myObj.nextLine();
	    try {
			IO.Read(cont, file + ".csv");
			correctFile=true;
			} catch (FileNotFoundException e) {
				System.out.println("File does not exist"); 
			}
	    
		}
	    
		while(running)
		{
			System.out.println("1 - Change data file");
			System.out.println("2 - Select by product quantity");
			System.out.println("3 - Select by expiration date");
			System.out.println("exit - Stop program");
			System.out.println("Enter selection");
		    String choice = myObj.nextLine();
		    
		    
		    switch(choice) {
		    case "1":
		    	//Clears current list in container
		    	//Checks if file exists
		    	cont.Reset();
		    	System.out.println("Enter file name (without .csv, for example: sample)");
			    String newFile = myObj.nextLine();
		    	try {
					IO.Read(cont, newFile+".csv");
				} catch (FileNotFoundException e) {
					System.out.println("File does not exist"); 
					break;
				}
		    	System.out.println("File successfully read");
		    	break;
		    
		    case "2":
		    	//Gets needed quantity from user input
		    	//Checks if input is correct
		    	//If correct prints list
		    	System.out.println("Enter product quantity");
		    	int quantity = 0;
		    	try {
		    		quantity = Integer.parseInt(myObj.nextLine());
		    		IO.Print(cont.getByRequiredQuantity(quantity), "Products that need to be ordered");
		    	}catch(Exception e) {
		    		System.out.println("Number is not correct");
		    	}
		    	break;	
		    case "3":
		    	//Gets needed quantity from user input
		    	//Checks if date is correct
		    	//If correct prints list
		    	Date expirationDate = new Date();
		    	System.out.println("Enter date");
		    	try {
		    		expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(myObj.nextLine());
		    		IO.Print(cont.getByExpirationDate(expirationDate), "Products expiring before "+expirationDate);
		    	}catch(Exception e) {
		    		System.out.println("Date is not correct");
		    	}
		    	break;
		    
		    case "exit":
		    	System.out.println("Program has stopped");
		    	running = false;
		    	break;
		    }
		   
		}
		myObj.close();
    }
	
	
}
