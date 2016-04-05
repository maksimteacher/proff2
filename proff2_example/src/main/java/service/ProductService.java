package service;

import java.util.List;

import domain.Product;


public interface ProductService {	
	void addNewProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	List<Product> getAllProducts(); 
}
