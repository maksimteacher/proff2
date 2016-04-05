package Action11.dao;

import Action11.domain.Product;

import java.util.List;


public interface ProductDao {
    Integer create(Product contructor);

    Product read(Long id);

    void update(Product contructor);

    void delete(Product contructor);

    List<Product> findAll();

}
