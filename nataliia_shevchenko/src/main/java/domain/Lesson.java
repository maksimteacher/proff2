package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="lessons")
public class Lesson {
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="lecture_id")
	private int lectId;
	
	@Column(name="department_id")
	private int depId;
	
	public Lesson() {}

	public Lesson(Long id, int lectId, int depId) {
		this.id = id;
		this.lectId = lectId;
		this.depId = depId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLectId() {
		return lectId;
	}

	public void setLectId(int lectId) {
		this.lectId = lectId;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", lectId=" + lectId + ", depId=" + depId + "]";
	}
	
	

}
