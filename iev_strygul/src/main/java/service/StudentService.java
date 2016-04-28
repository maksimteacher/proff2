package service;

import java.util.List;

import domain.Student;

public interface StudentService {
	Student getStudent(Long id);
	void addStudent(Student st);
	void updateStudent(Student st);
	void deleteStudent(Student st);
	void addAll(List<Student> students);
	void deleteAll(List<Student> students);
	List<Student> getAllDepartments();
}
