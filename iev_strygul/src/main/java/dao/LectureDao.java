package dao;

import java.util.List;

import domain.Lecture;

public interface LectureDao {
	Lecture read(Long id);
	void update(Lecture lecture);
	void delete(Lecture lecture);
	List<Lecture> findAll();
	List<Lecture> findByDep(Long depId);
	List<Lecture> findByStud(Long studentIt);
	List<Lecture> findBySchool(Long schoolId);
}
