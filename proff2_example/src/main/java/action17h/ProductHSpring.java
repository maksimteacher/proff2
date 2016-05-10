package action17h;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Product;
import service.ProductServiceImpl;

public class ProductHSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action17h/configH.xml");
		ProductServiceImpl servisProduct = (ProductServiceImpl)context.getBean("serviceProduct");
		//
		ProductDao daoProduct = new ProductDaoImpl();
		ProductServiceImpl serviceProduct1 = new ProductServiceImpl(daoProduct);
		//
		List<Product> products = servisProduct.getAllProducts();
		
	}
}
