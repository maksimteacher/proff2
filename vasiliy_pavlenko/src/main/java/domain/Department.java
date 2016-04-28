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
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="number_level")
	private int number_level;
	
	@Column(name="school_id")
	private int school_id;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number_level
	 */
	public int getNumber_level() {
		return number_level;
	}

	/**
	 * @param number_level the number_level to set
	 */
	public void setNumber_level(int number_level) {
		this.number_level = number_level;
	}

	/**
	 * @return the school_id
	 */
	public int getSchool_id() {
		return school_id;
	}

	/**
	 * @param school_id the school_id to set
	 */
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	
	
	
}
