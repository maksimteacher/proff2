package action11;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Product;
import util.HibernateUtil;

public class HibernateDaoProduct {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//ProductDao productDao = new ProductDaoImpl(factory);

		//productDao.create(new Product("NewProductName5", "1234"));
		
		//System.out.println(productDao.read(3L)); 
		//productDao.update("NewProductName5", "6");

		//List<Product> products = productDao.findAll();
		//System.out.println(products);
		
		if(factory!=null){
			factory.close();
		}
	}
}
