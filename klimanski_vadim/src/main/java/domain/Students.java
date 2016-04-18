package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "school")
public class Students {

	@Id
		
    @Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "Login")
	private String login;
	
	@Column(name= "pass")
	private int pass;
	
	@Column(name= "departments_id")
	private int departments_id;

	public Students(Long id, String name, String login, int pass, int departments_id) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.departments_id = departments_id;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", departments_id="
				+ departments_id + "]";
	}
	
	
	
	
}
