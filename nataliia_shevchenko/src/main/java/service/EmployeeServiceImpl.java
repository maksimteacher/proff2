package service;

import java.util.List;

import dao.EmployeeDao;
import domain.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao = null;
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void addNewEmployee(Employee employee) {
		employeeDao.create(employee);		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.update(employee);		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.delete(employee);		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

}
