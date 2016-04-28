package dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Product;
import util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);
	
	

	@Override
	public Long create(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	@Override
	public Product read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Product product = null;
		try {
			product = (Product) session.get(Product.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return product;
	}

	@Override
	public void update(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void delete(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Product> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// Query query = session.createQuery("from product");
			Query query = session.createQuery("from Product");
			return query.list();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Product> findProductsByBeginString(String begin) {
		return null;
	}

}
