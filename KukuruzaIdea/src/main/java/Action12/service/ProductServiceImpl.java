package Action12.service;

import Action11.dao.ProductDao;
import resourses.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = null;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addNewProduct(Product product) {
        productDao.create(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);

    }

    @Override
    public void deleteProduct(Product product) {
        productDao.delete(product);

    }

}
