package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Contructor;

public class ContructorDaoImpl implements ContructorDao {
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);
	private SessionFactory factory;

	public ContructorDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Long create(Contructor contructor) {
		Session session = factory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(contructor);
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
	public Contructor read(Long id) {
		Session session = factory.openSession();
		Contructor contructor = null;
		try {
			contructor = (Contructor) session.get(Contructor.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return contructor;
	}

	@Override
	public void update(Contructor contructor) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.update(contructor);
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
	public void delete(Contructor contructor) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.delete(contructor);
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
	public List<Contructor> findAll() {
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("from Contructor");
			return query.list();
		} finally {
			session.close();
		}
	}
}
