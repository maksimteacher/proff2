package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(generator ="increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="schools_id")
	private School school;
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
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
	
	@Override
	public String toString() {
		return "[Id: " + id + ", name: " + name + "]";
	}
	
}
