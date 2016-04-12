package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="scores")
public class Score {
	
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="lesson_id")
	private int lesId;
	

	@Column(name="student_id")
	private int studId;
	
	@Column(name="score")
	private String score;
	
	public Score() {}

	public Score(Long id, int lesId, int studId, String score) {		
		this.id = id;
		this.lesId = lesId;
		this.studId = studId;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLesId() {
		return lesId;
	}

	public void setLesId(int lesId) {
		this.lesId = lesId;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", lesId=" + lesId + ", studId=" + studId + ", score=" + score + "]";
	}
	
	

}
