package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Employee;
import util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public Long create(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(employee);
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
	public Employee read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = null;
		try {
			employee = (Employee) session.get(Employee.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return employee;
	}

	@Override
	public void update(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(employee);
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
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// Query query = session.createQuery("from product");
			Query query = session.createQuery("from Employee");
			return query.list();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> findEmployeesByBeginString(String begin) {
		 return null;
	}

}
