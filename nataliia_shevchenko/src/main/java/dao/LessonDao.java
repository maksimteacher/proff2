package dao;

import java.util.List;

import domain.Lesson;

public interface LessonDao {
	Long create(Lesson lesson);
	Lesson read(Long idLesson);
    void update(Lesson lesson);
    void delete(Lesson lesson);
    List<Lesson> findAll();
    //List<Lesson> findAllDepartmentsForSchool(Long idDepart);

}
