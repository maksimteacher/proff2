package dao;

import java.util.List;

import domain.Lecture;

public interface LectureDao {
	
		Long create(Lecture lecture);
		Lecture read(Long idLecture);
	    void update(Lecture lecture);
	    void delete(Lecture lecture);
	    List<Lecture> findAll();
	    List<Lecture> findAllLecturesWhichWereIssuedForDepartment(Long idDepart);
	    List<Lecture> findAllLecturesWhichWereIssuedForStudent(Long idStudent);
	    List<Lecture> findAllLecturesWhichWereIssuedForSchool(Long idSchool);
}
