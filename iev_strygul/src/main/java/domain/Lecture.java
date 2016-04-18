package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="lectures")
public class Lecture  {
	
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinTable(name="lectures_departments", 
	joinColumns=@JoinColumn(name="lectures_id"), 
	inverseJoinColumns=@JoinColumn(name="departments_id"))
	private Department dep;
	
	public Lecture() {}

	public Lecture(Long id, String name, Department dep) {
		this.id = id;
		this.name = name;
		this.dep = dep;
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
		return "Lecture [id=" + id + ", name=" + name + "]";
	}
}

