package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Department;
import domain.Student;
import util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Long create(Student stud) {
		Long id = null;
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			id = (Long) session.save(stud);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public Student read(Long id) {
		Student stud = null;
		Session session = HibernateUtil.getSession();
		try {
			session.get(Student.class, id);
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return stud;
	}

	@Override
	public void update(Student stud) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(stud);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void delete(Student stud) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(stud);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<Student> readAll() {
		List<Student> list = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("from students");
			list = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public List<Student> findAllStudentsByDep(Long idDep) {
		List<Student> list = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createSQLQuery("SELECT * FROM students " + 
		"JOIN departments ON departments.id = students.departments_id WHERE departments.id = :id").addEntity(Student.class);
			query.setLong("id", idDep);
			list = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public List<Student> findStudentsBySchoolSortedByName(Long idSchool) {
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery("SELECT * FROM students WHERE departments_id IN " +
		"(SELECT id FROM departments WHERE schools_id = :id) ORDER BY(name)").addEntity(Student.class);
		query.setLong("id", idSchool);
		List<Student> list = query.list();
		return list;
	}

}
