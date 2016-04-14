package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import domain.School;

public interface SchoolDao {
	Long addSchool(School school) throws HibernateException;
	School getSchool(Long id) throws HibernateException;
	List<School> getSchools() throws HibernateException;
	void update(School school) throws HibernateException;
	void delete(School school) throws HibernateException;
}
