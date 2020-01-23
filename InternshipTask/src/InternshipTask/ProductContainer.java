package InternshipTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


//Container class for keeping all the products in the same place
//Implements methods for merge, sorting, checking for correct parameters
public class ProductContainer {
	private List<Product> productList;
	
	public ProductContainer() {
		productList = new ArrayList<Product>();
	}
	
	public void Reset() {
		this.productList.clear();
	}

	public List<Product> getProductList() {
		Collections.sort(productList);
		return productList;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	
	//Adds products to the new list
	private List<Product> mergeProducts(){
		List<Product> merged = new ArrayList<Product>();
		for(Product p : this.productList) {
		    int index = merged.indexOf(p); //Checks equals override in class (same name, code, expiration date)
		    if(index != -1) { 
		        merged.set(index, merged.get(index).merge(p));
		    } else {
		        merged.add(p);
		    }
		}
		return merged;
	}
	
	
	//Method gets date and selects products with lower date than given through parameters
	//All the duplicates are merged before checking in the list
	//After selection returns List of products
	public List<Product> getByExpirationDate(Date expirationDate){
		List<Product> filteredList = new ArrayList<Product>();
		List<Product> mergedList = mergeProducts();
		for(Product prod:mergedList) {
			if(prod.getExpirationDate().compareTo(expirationDate) < 1) {
				filteredList.add(prod);
			}
		}
		Collections.sort(filteredList);
		return filteredList;
	}
	
	
	//Method gets needed and selects products with lower than needed quantity
	//All the duplicates are merged before checking in the list
	//After selection returns List of products
	public List<Product> getByRequiredQuantity(int quantity){
		List<Product> filteredList = new ArrayList<Product>();
		List<Product> mergedList = mergeProducts();
		for(Product prod:mergedList) {
			if(prod.getQuantity() < quantity) {
				filteredList.add(prod);
			}
		}
		Collections.sort(filteredList);
		return filteredList;
	}
}
