package service;

import java.util.List;

import domain.Department;

public interface DepartmentService {
	Department getDepartment(Long id);
	void addDepartment(Department dep);
	void updateDepartment(Department dep);
	void deleteDepartment(Department dep);
	void addAll(List<Department> deps);
	void deleteAll(List<Department> deps);
	List<Department> getAllDepartments();
}
