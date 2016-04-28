package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Student;
import util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {
	private static Logger log = Logger.getLogger(StudentDaoImpl.class);

	@Override
	public Long create(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(student);
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
	public Student read(Long idStud) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = null;
		try {
			student = (Student)session.get(Student.class, idStud);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public void update(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(student);
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
	public void delete(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(student);
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
	public List<Student> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Student");
			return query.list();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Student> findAllStudentsForDepartment(Long idDepart) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Student> list = null;
		try {
			session = factory.openSession();
			query = session.createSQLQuery("select * from students " + "where students.department_id = :id").addEntity(Student.class);
			query.setLong("id", idDepart);
			list = query.list();
			System.out.println("List of students for the particular class/department: " + list);			
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
