package InternshipTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Product implements Comparable<Product> {
	private String Name;
	private long Code;
	private int Quantity;
	private Date ExpirationDate;
	
	public Product(String name, long code, Date expirationDate, int quantity) {
		this.Name = name;
		this.Code = code;
		this.Quantity = quantity;
		this.ExpirationDate = expirationDate;
	}
	
	//Encapsulation methods
	
	//Name setter
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	//Code setter
	public long getCode() {
		return this.Code;
	}
	public void setCode(long code) {
		this.Code = code;
	}
	
	//quantity setter
	public int getQuantity() {
		return this.Quantity;
	}
	
	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}
	
	//Expiration Date setter
	public Date getExpirationDate() {
		return this.ExpirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.ExpirationDate = expirationDate;
	}

	
	//Compare override for sorting
	//Compares by name
	@Override
	public int compareTo(Product o) {
		return this.getName().toLowerCase().compareTo(o.getName().toLowerCase());
	}
	
	//Equals override for duplicate checking (same name, code, expiration date)
	@Override
	public boolean equals(Object o) { 
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Product)) { 
            return false; 
        } 
        
        Product p = (Product) o;
        if(this.Name.equals(p.getName()) && (this.Code == p.getCode()) && (this.ExpirationDate.equals(p.getExpirationDate())))
        {
        	return true;
        }
		else
    		return false;
	}
	
	//HashCode for checking if same duplicate is already in the list
	@Override
    public int hashCode() {
        return Objects.hash(this.Name, this.Code, this.ExpirationDate);
    }
	
	//Adds quantity of both products
	public Product merge (Product p) {
		return new Product(this.Name, this.Code, this.ExpirationDate, this.Quantity+p.getQuantity());
	}
	
	public String toString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return String.format("|%-20s|%-20d|%10d|%15s|", this.Name, this.Code, this.Quantity, df.format(this.ExpirationDate));
	}
}
