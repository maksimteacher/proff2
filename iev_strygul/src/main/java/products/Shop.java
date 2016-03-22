package products;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Shop {

	public static void main(String[] args) {
Map<Product, String> map = new HashMap<>();
		
		map.put(new Product("Milk1", TypeProducts.Milk, 001), "customer1");
		map.put(new Product("Milk2", TypeProducts.Milk, 002), "customer2");
		map.put(new Product("Bread1", TypeProducts.Bread, 003), "customer3");
		map.put(new Product("Bread2", TypeProducts.Bread, 004), "customer4");
		map.put(new Product("Yogurt1", TypeProducts.Yogurt, 005), "customer5");
		map.put(new Product("Yogurt2", TypeProducts.Yogurt, 006), "customer6");
		
		//List of customers sorted alphabetic in ascending order
		SortedSet<Map.Entry<Product, String>> entriesSortedByValuesAscending = new TreeSet<Map.Entry<Product, String>>
		((a, b) -> a.getValue().compareTo(b.getValue()));
		
		entriesSortedByValuesAscending.addAll(map.entrySet());
		
		for(Map.Entry<Product, String> ent : entriesSortedByValuesAscending) {
			System.out.println(ent.getValue() + " " + ent.getKey());
		}
		
		System.out.println();
		
		//List of customers sorted alphabetic in ascending order
		SortedSet<Map.Entry<Product, String>> entriesSortedByValuesDescending = new TreeSet<Map.Entry<Product, String>>
		((a, b) -> b.getValue().compareTo(a.getValue()));
		entriesSortedByValuesDescending.addAll(map.entrySet());
		
		for(Map.Entry<Product, String> ent : entriesSortedByValuesDescending) {
			System.out.println(ent.getValue() + " " + ent.getKey());
		}
		
		System.out.println();
		
		//List of unique products by product type (Bread)
		for(Map.Entry<Product, String> ent : map.entrySet()) {
			if(ent.getKey().getType()==TypeProducts.Bread) {
				System.out.println(ent.getValue() + " " + ent.getKey());
			}
		}

	}

}
