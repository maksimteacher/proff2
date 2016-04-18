package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "school")
public class School {
	@Id
	@GeneratedValue(generator = "inc")
	
    @Column(name= "id")
	private Long id;
	
	@Column(name="name")
	private String name;

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
	
	public School() {
	}
	public School(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "School " + name;
	}

}
