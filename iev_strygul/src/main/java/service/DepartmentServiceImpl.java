package service;

import java.util.List;

import dao.DepartmentDaoImpl;
import domain.Department;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDaoImpl depDao;
	
	public DepartmentServiceImpl() {
		depDao = new DepartmentDaoImpl();
	}
	
	public List<Department> getAllDepartmentsForSchool(Long idSchool) {
		return depDao.findAllDepartmentsForSchool(idSchool);
	}

	@Override
	public Department getDepartment(Long id) {
		Department dep = depDao.getDepartment(id);
		return dep;
	}

	@Override
	public void addDepartment(Department dep) {
		depDao.addDepartment(dep);
	}

	@Override
	public void updateDepartment(Department dep) {
		depDao.update(dep);
	}

	@Override
	public void deleteDepartment(Department dep) {
		depDao.delete(dep);
	}

	@Override
	public void addAll(List<Department> deps) {
		for(Department d : deps) {
			depDao.addDepartment(d);
		}
		
	}

	@Override
	public void deleteAll(List<Department> deps) {
		for(Department d : deps) {
			depDao.delete(d);
		}
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> deps = depDao.getDepartments();
		return deps;
	}

}
