package action04;

import java.util.HashMap;
import java.util.Map;

public class ProductShop {
	
	public static void main(String[] args) {
		Map<Product, String> shop = new HashMap<>();
		
		shop.put(new Product("Milk 0%", TypeProduct.Milk, 1), "Yagotyn");
		shop.put(new Product("Milk 2.5%", TypeProduct.Milk, 1), "Yagotyn");
		shop.put(new Product("Milk 3%", TypeProduct.Milk, 1), "Yagotyn");
		
	}

	

}
