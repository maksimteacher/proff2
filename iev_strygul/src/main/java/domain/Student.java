package domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="login")
	private String login;
	
	@Column(name="pass")
	private String pass;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="departments_id")
	private Department dep;
	
	public Student() {}

	public Student(Long id, String name, String login, String pass, Department dep) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.dep = dep;
	}
	
	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Student(Long id, String name){
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", department=" + dep + "]";
	}
	
	

}

