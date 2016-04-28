package Action11.dao;

import resourses.Product;

import java.util.List;


public interface ProductDao {
    Integer create(Product contructor);

    Product read(Integer id);

    void update(Product contructor);

    void delete(Product contructor);

    List<Product> findAll();

}
