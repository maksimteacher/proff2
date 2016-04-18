package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Departments;


public class DepartmentsImpDao implements DepatmentsDao{
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);
	private SessionFactory factory;

	public DepartmentsImpDao(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Long create(Departments departments) {
		Session session = factory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(departments);
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
	public Departments read(Long id) {
		Session session = factory.openSession();
		Departments departments = null;
		try {
			departments = (Departments) session.get(Departments.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return departments;
	}
	
	


	@Override
	public void update(Departments departments) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.update(departments);
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
	public void delete(Departments departments) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.delete(departments);
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
	public List<Departments> findAll() {
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("from Contructor");
			return query.list();
		} finally {
			session.close();
		}
	}

	}

