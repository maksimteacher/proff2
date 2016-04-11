package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Product;
import domain.School;
import util.HibernateUtil;

public class SchoolDaoImpl implements SchoolDao {
	private static Logger log = Logger.getLogger(SchoolDaoImpl.class);

	@Override
	public Long create(School school) {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		School school = null;
		try {
			school = (School)session.get(School.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return school;
	}

	@Override
	public void update(School school) {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from School");
			return query.list();
		} finally {
			session.close();
		}
	}

/*Query: 
select * from students 
join departments on students.department_id = departments.id
join schools on schools.id = departments.school_id
where schools.id = 1;*/
	
	@Override
	public List<School> findAllUsersForEachSchool(String search) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<School> list = null;
		try {
			session = factory.openSession();
			//HQL
			query = session.createQuery("from School")
					.setParameter("name", "user_");
			list = query.list();
			System.out.println(list);
		} catch (HibernateException e) {
			log.error("Open session failed", e);
		} finally {
			if (session != null) {
				session.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		log.info("session = " + session);
	}
}
