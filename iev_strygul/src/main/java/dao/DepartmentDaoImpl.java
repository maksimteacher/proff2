package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Department;
import util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public Long addDepartment(Department department) throws HibernateException {
		Long id = null;
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			id = (Long) session.save(department);
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
	public Department getDepartment(Long id) throws HibernateException {
		Department dep = null;
		Session session = HibernateUtil.getSession();
		try {
			session.get(Department.class, id);
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return dep;
	}

	@Override
	public List<Department> getDepartments() throws HibernateException {
		List<Department> list = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("from Department");
			list = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public void update(Department department) throws HibernateException {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(department);
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
	public void delete(Department department) throws HibernateException {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(department);
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
	public List<Department> findAllDepartmentsForSchool(Long idSchool) {
			Session session = HibernateUtil.getSession();
			Query query = null;
			List<Department> list = null;
			try {
				query = session.createSQLQuery("select * from departments join schools on schools.id = departments.schools_id " + 
	                    "where schools.id = :id ").addEntity(Department.class);
				query.setLong("id", idSchool);
				list = query.list();
				System.out.println("List of classes(departments) for the particular school: " + list);
				
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				if(session != null && session.isOpen()) {
					session.close();
				}
			}
			return list;
	}

}
