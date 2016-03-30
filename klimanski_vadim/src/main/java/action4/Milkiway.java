package action4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public enum Milkiway{
 Bread, Yogurt, Milk;


 static class Product{
	/* private String name;
	 private TypeProduct type;
	 private int party;*/
	 
	 
	public Product(String string, TypeProduct bread, int i) {
		
	
	/*}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeProduct getType() {
		return type;
	}
	public void setType(TypeProduct type) {
		this.type = type;
	}
	public int getParty() {
		return party;
	}
	public void setParty(int party) {
		this.party = party;
	}
	 
	 
	}
	 */
	}
	  public static class TypeofProducts {
		  public static void main(String[] args) {
			  
		 Map<Product,String> contructors = new HashMap<Product,String>();
		 
		 
		  contructors.put(new Product("Bread White",TypeProduct.Bread, 10),"airma a");
		  contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 10),"birma b");
		  contructors.put(new Product("Bread Grey",TypeProduct.Bread, 12),"cirma c");
		  contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 12),"dirma d");
		  contructors.put(new Product("Milk with Chokolate",TypeProduct.Milk, 14),"Firma 1");
		  contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		  contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		  contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 16),"Firma 1");
		  contructors.put(new Product("Milk with Chokolate",TypeProduct.Milk, 14),"Firma 1");
		  contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		  contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		  contructors.put(new Product("Bread Grey",TypeProduct.Bread, 18),"Firma 1");
		  contructors.put(new Product("Bread White",TypeProduct.Bread, 20),"Firma 2");
		  contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 20),"Firma 2");
		  contructors.put(new Product("Bread Grey",TypeProduct.Bread, 20),"Firma 2");
		  contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 20),"Firma 2");
		  
		  Collection<String> firmas = contructors.values();
		  Set<String> firmsSet = new TreeSet<>();
		  for(String s:firmas){
			  firmsSet.add(s);
			  System.out.println(firmsSet);	  
			  }
		//  System.out.println(firmsSet);
	  }
	  }
 }
}
		  
		//Set<Map.Entry<Product, String>> set = contructors.entrySet();
		