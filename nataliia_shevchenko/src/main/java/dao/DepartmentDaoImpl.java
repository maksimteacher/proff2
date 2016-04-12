package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Department;
import util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private static Logger log = Logger.getLogger(DepartmentDaoImpl.class);

	@Override
	public Long create(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(department);
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
	public Department read(Long idDepart) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Department department = null;
		try {
			department = (Department)session.get(Department.class, idDepart);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return department;
	}

	@Override
	public void update(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(department);
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
	public void delete(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(department);
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
	public List<Department> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Department");
			return query.list();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Department> findAllDepartmentsForSchool(Long idSchool) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Department> list = null;
		try {
			session = factory.openSession();
			query = session.createSQLQuery("select * from departments join schools on schools.id = departments.school_id " + 
                    "where schools.id = :id ").addEntity(Department.class);
			query.setLong("id", idSchool);
			list = query.list();
			System.out.println("List of classes(departments) for the particular school: " + list);
			
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
		return list;
	}
}
