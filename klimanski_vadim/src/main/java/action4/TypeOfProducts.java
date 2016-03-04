package action4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

 /*public class Product{
		 public Product(String name, TypeProduct type, int price) {
			}
		 		 }*/

 enum TypeOfProducts{
	 Bread, Yogurt, Milk;
	
	public static void main(String[] args) {
	  class ProductShop {
		Map<ProductShop,String> market = new HashMap<ProductShop,String>();
		 public ProductShop(String string, TypeProduct bread, int i){
		  market.put(new ProductShop("Bread White",TypeProduct.Bread, 10),"Firma 3");
		  market.put(new ProductShop("Super Yogurt",TypeProduct.Yogurt, 10),"Firma 3");
		  market.put(new ProductShop("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		  market.put(new ProductShop("Bread a half",TypeProduct.Bread, 20), "Bread & Sons");
		  market.put(new ProductShop("Cow Milk", TypeProduct.Milk, 8), "Milk reaver");
		  market.put(new ProductShop("Yogurt of Hell", TypeProduct.Yogurt, 26), "Roda break");
		  
		  Set<Map.Entry<ProductShop, String>> set = market.entrySet();
	
		 
		 /* List list = new ArrayList(market.entrySet());
		 Collection.sort(list, new Comparator<Map.Entry<ProductShop,String>>(){
			 @Override
			 public int compare(Entry e1, Entry e2) {
				    return ((Enum<TypeOfProducts>) e1.getValue()).compareTo((TypeOfProducts) e2.getValue());
				  }
				 */
				//});
		 }
			  
		  //}
 		  
		 }
	}}
		
	  
 // for(Map.Entry<ProductShop, String> entry : set){
 // System.out.println(entry.getKey());}
	  
		/* private static Map<Product, String> LinkedHashMap(){
			return market;}
		 */
		 
				/*Set<Map.Entry<Product, String>> set = market.entrySet();
				for(Map.Entry<Product,String> entry : set){
					System.out.println("["+entry.getKey() +","+entry.getValue()+"]");*/

/*Map<Integer, Integer> map = new HashMap<>();
List list = new ArrayList(market.entrySet());
Collections.sortlist, new Comparator<Map.Entry<Integer, Integer>>() {
    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
        return a.getKey() - b.getValue();
    }
};

* market = new TreeMap<ProductShop,String>(market);
		  System.out.println(market);
		  Map<ProductShop,String> market_2 = new TreeMap<ProductShop,String>();
*
*/
	
	 
	 
	