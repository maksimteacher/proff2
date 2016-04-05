package Action11.domain;

import java.util.List;

import Action11.dao.ProductDao;
import Action11.dao.ProductDaoImpl;
import Action11.util.HibernateUtil;
import org.hibernate.SessionFactory;


public class HibernateDaoProduct {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        ProductDao productDao = new ProductDaoImpl(factory);

        productDao.create(new Product("brasd","123"));

        List<Product> products = productDao.findAll();
        System.out.println(products);

        if (factory != null) {
            factory.close();
        }
    }
}
