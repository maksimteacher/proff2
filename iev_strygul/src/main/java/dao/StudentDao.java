package dao;

import java.util.List;

import domain.Student;

public interface StudentDao {
	Long create(Student stud);
	Student read(Long id);
	void update(Student stud);
	void delete(Student stud);
	List<Student> readAll();
}
