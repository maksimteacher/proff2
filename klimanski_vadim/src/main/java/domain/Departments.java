package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "school")
public class Departments {
	
	@Id
    @Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "number_level")
	private int number_level;
	
	@Column(name= "school_id")
	private int school_id;

	public Departments(){
	}
	
	public Departments(Long id, String name, int number_level, int school_id) {
		this.id = id;
		this.name = name;
		this.number_level = number_level;
		this.school_id = school_id;
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", number_level=" + number_level + ", school_id="
				+ school_id + "]";
	}
	
	
}
