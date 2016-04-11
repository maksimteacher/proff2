package view;

import domain.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserViewer {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty login;
	private SimpleStringProperty pass;
	private SimpleIntegerProperty empId;
	
	public UserViewer(int id, String name, String login, String pass, int empId) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.login = new SimpleStringProperty(login);
		this.pass = new SimpleStringProperty(pass);
		this.empId = new SimpleIntegerProperty(empId);
	}
	
	public UserViewer(User user) {
		this(user.getId().intValue(), user.getName(), user.getLogin(), user.getPass(), user.getEmpId().intValue());
	}
	
	public User toUser(){
		User user = new User(getName(),getLogin());
		user.setId((long)getId());
		return user;
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
	
	public String getLogin() {
		return login.get();
	}

	public void setLogin(String login) {
		this.login.set(login);
	}

	public String getPass() {
		return pass.get();
	}

	public void setPass(String pass) {
		this.pass.set(pass);
	}

	public Integer getEmpId() {
		return empId.get();
	}

	public void setEmpId(Integer empId) {
		this.empId.set(empId);
	}

}
