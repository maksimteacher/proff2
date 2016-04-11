package service;

import java.util.List;
import domain.Employee;

public interface EmployeeService {
	
	void addNewEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	List<Employee> getAllEmployees(); 
	

}
