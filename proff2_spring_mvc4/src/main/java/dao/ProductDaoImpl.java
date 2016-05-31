package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import domain.Product;


@Repository(value="productDao")
public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	@Autowired(required=true)
	@Qualifier(value="mySessionFactory")
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public Long create(Product product) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(product);
		log.error("Product saved successfully, product="+product);
		return id;
	}

	@Override
	public Product read(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		log.error("Product read successfully, product="+product);
		return product;
	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		log.error("Product update successfully, product="+product);
	}

	@Override
	public void delete(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		log.info("Person deleted successfully, person details="+product);
	}

	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		return query.list();
	}

}
