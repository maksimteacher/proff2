package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import domain.School;
import util.HibernateUtil;

public class SchoolDaoImpl implements SchoolDao {
	
	private static Logger log = Logger.getLogger(SchoolDaoImpl.class);

	@Override
	public Long addSchool(School school) {
		Long id = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(school);
			session.getTransaction().commit();
		} catch (HibernateException hibernateExc) {
			hibernateExc.printStackTrace();
			session.getTransaction().rollback();
			log.error("Transaction error");
		}
		return id;
	}

	@Override
	public School getSchool(Long id) {
		School school = null;
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			school = (School)session.get(School.class, id);
		} catch (HibernateException hibernateException) {
			log.error("Hibernate exception");
		}
		if(session != null) {
			session.close();
		}
		return school;
	}

	@Override
	public List<School> getSchools() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(School school) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(School school) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
