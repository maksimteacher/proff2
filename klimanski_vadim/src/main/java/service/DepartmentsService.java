package service;

import java.util.List;

import domain.Departments;

public interface DepartmentsService {

	Departments get(Long id);

	List<Departments> getAllDepartment();

	void add(Departments department);

}
