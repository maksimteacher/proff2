package action_04.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ProductShop {
	Map<Product, String> contructors;

	public ProductShop() {
		contructors = new HashMap<Product, String>();
		contructors.put(new Product("Bread White", ProductType.Bread, 10), "Firma 3");
		contructors.put(new Product("Super Yogurt", ProductType.Yogurt, 10), "Firma 3");
		contructors.put(new Product("Bread Grey", ProductType.Bread, 12), "Firma 3");
		contructors.put(new Product("Yogurt for Java Developers", ProductType.Yogurt, 12), "Firma 3");
		contructors.put(new Product("Milk with Shokolate", ProductType.Milk, 14), "Firma 1");
		contructors.put(new Product("Simple Yogurt", ProductType.Yogurt, 14), "Firma 1");
		contructors.put(new Product("Bread Grey", ProductType.Bread, 16), "Firma 1");
		contructors.put(new Product("Yogurt for Java Developers", ProductType.Yogurt, 16), "Firma 1");
		contructors.put(new Product("Milk with Shokolate", ProductType.Milk, 14), "Firma 1");
		contructors.put(new Product("Simple Yogurt", ProductType.Yogurt, 14), "Firma 1");
		contructors.put(new Product("Bread Grey", ProductType.Bread, 16), "Firma 1");
		contructors.put(new Product("Bread Grey", ProductType.Bread, 18), "Firma 1");
		contructors.put(new Product("Bread White", ProductType.Bread, 20), "Firma 2");
		contructors.put(new Product("Super Yogurt", ProductType.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Bread Grey", ProductType.Bread, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", ProductType.Yogurt, 20), "Firma 2");

	}

	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		Collection<String> list = shop.contructors.values();
		System.out.println(list);
		Set<String> set = new TreeSet<String>(list);
		System.out.println(set);
		List<String> l = new ArrayList<String>(set);
		System.out.println(l);
		l.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(l);
		
		Set<Product> pr = shop.contructors.keySet();
		System.out.println(pr);
		Set<String> prSet = new TreeSet<String>();
		for (Product p : pr) {
			prSet.add(p.getName());
		}
		System.out.println(prSet);
	}

}
