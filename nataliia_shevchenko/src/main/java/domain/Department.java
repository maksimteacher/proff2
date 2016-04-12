package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="number_level")
	private int numlev;
	

	@Column(name="school_id")
	private int schId;
	
	public Department (){}

	public Department(Long id, String name, int numlev, int schId) {
		this.id = id;
		this.name = name;
		this.numlev = numlev;
		this.schId = schId;
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

	public int getNumlev() {
		return numlev;
	}

	public void setNumlev(int numlev) {
		this.numlev = numlev;
	}

	public int getSchId() {
		return schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", numlev=" + numlev + ", schId=" + schId + "]";
	}
	

}
