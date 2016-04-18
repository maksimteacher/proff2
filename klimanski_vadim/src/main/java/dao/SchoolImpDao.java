package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.School;

public class SchoolImpDao implements SchoolDao{
	
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);
	private SessionFactory factory;

	public SchoolImpDao(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Long create(School school) {
		Session session = factory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(school);
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
	public School read(Long id) {
		Session session = factory.openSession();
		School contructor = null;
		try {
			contructor = (School) session.get(School.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return contructor;
	}
	
	


	@Override
	public void update(School school) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.update(school);
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
	public void delete(School school) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.delete(school);
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
	public List<School> findAll() {
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("from Contructor");
			return query.list();
		} finally {
			session.close();
		}
	}

	}



