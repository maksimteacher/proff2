package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column(name="number_level")
	private int numlev;
	
	public Lecture() {}

	public Lecture(Long id, String name, int numlev) {
		this.id = id;
		this.name = name;
		this.numlev = numlev;
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

	@Override
	public String toString() {
		return "Lecture [id=" + id + ", name=" + name + ", numlev=" + numlev + "]";
	}
	
	
	
	
	
	

}
