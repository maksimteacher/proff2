package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDao;
import domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public void addNewProduct(Product product) {
		productDao.create(product);
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDao.update(product);
		
	}

	@Override
	@Transactional
	public void deleteProduct(Product product) {
		productDao.delete(product);
		
	}

}
