package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import domain.School;
import util.HibernateUtil;

public class SchoolDaoImpl implements SchoolDao {

	private static Logger log = Logger.getLogger(SchoolDaoImpl.class);
	
	public SchoolDaoImpl() {
		System.out.println("SchoolDaoImpl Created");
	}

	@Override
	public Long addSchool(School school) {
		Long id = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(school);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			log.error("Transaction error");
			throw he;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public School getSchool(Long id) throws HibernateException {
		School school = null;
		Session session = HibernateUtil.getSession();
		try {
			school = (School) session.get(School.class, id);
		} catch (HibernateException he) {
			log.error("Hibernate exception");
			throw he;
		} finally {
			if(session != null && session.isOpen()) session.close();
		}
		return school;
	}

	@Override
	public List<School> getSchools() throws HibernateException {
		List<School> list = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("from School");
			list = query.list();
		} catch (HibernateException he) {
			log.error("Hibernate exception");
			throw he;
		}
		return list;
	}

	@Override
	public void update(School school) throws HibernateException {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(school);
			tx.commit();
		} catch (HibernateException he) {
			log.error("Hibernate exception");
			session.getTransaction().rollback();
			throw he;
		} finally {
			if(session != null && session.isOpen()) session.close();
		}

	}

	@Override
	public void delete(School school) throws HibernateException {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(school);
			tx.commit();
		} catch (HibernateException he) {
			log.error("Hibernate exception");
			throw he;
		} finally {
			if(session != null && session.isOpen()) session.close();
		}
	}

}
