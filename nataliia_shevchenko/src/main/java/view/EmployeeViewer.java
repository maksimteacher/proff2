package view;

import domain.Employee;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeViewer {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty salary;

	public EmployeeViewer(int id, String name, int salary) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.salary = new SimpleIntegerProperty(salary);
	}

	public EmployeeViewer(Employee employee) {
		this(employee.getId().intValue(), employee.getName(), employee.getSalary());
	}
	public Employee toEmployee(){
		Employee employee = new Employee(getName(),getSalary());
		employee.setId((long)getId());
		return employee;
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public Integer getSalary() {
		return salary.get();
	}

	public void setSalary(Integer salary) {
		this.salary.set(salary);
	}
}
