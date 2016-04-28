package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Students;

public class StudentsImpDao implements StudentsDao{
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);
	private SessionFactory factory;

	public StudentsImpDao(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Long create(Students students) {
		Session session = factory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(students);
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
	public Students read(Long id) {
		Session session = factory.openSession();
		Students students = null;
		try {
			students = (Students) session.get(Students.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return students;
	}
	
	


	@Override
	public void update(Students students) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.update(students);
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
	public void delete(Students students) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.delete(students);
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
	public List<Students> findAll() {
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("from Contructor");
			return query.list();
		} finally {
			session.close();
		}
	}


}
