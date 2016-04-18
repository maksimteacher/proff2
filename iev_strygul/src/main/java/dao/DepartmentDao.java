package dao;

import java.util.List;

import org.hibernate.HibernateException;

import domain.Department;

public interface DepartmentDao {
	Long addDepartment(Department department) throws HibernateException;
	Department getDepartment(Long id) throws HibernateException;
	List<Department> getDepartments() throws HibernateException;
	void update(Department department) throws HibernateException;
	void delete(Department department) throws HibernateException;
	List<Department> findAllDepartmentsForSchool(Long idDepart);
}
