package Action11.dao;

import java.util.List;

import Action11.domain.Product;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ProductDaoImpl implements ProductDao {
    private static Logger log = Logger.getLogger(ProductDaoImpl.class);
    private SessionFactory factory;

    public ProductDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Integer create(Product product) {
        Session session = factory.openSession();
        Integer id = null;
        try {
            session.beginTransaction();
            id = (Integer) session.save(product);
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
        Session session = factory.openSession();
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
        Session session = factory.openSession();
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
        Session session = factory.openSession();
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
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Product");
            return query.list();
        } finally {
            session.close();
        }
    }

}
