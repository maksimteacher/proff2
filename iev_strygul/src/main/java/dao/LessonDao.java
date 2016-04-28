package dao;

import java.util.List;

import domain.Lesson;

public interface LessonDao {
	Long create(Lesson lesson);
	Lesson read(Long id);
	void update(Lesson lesson);
	void delete(Lesson lesson);
	List<Lesson> findAll();
	List<Lesson> findByDep(Long depId);
	List<Lesson> findByStud(Long studentIt);
	List<Lesson> findBySchool(Long schoolId);
}
