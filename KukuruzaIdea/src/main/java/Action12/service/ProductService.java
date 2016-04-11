package Action12.service;

import resourses.Product;

import java.util.List;


public interface ProductService {
    void addNewProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getAllProducts();
}
