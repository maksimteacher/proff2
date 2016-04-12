package dao;

import java.util.List;

import domain.Student;

public interface StudentDao {
	Long create(Student student);
	Student read(Long idStud);
    void update(Student student);
    void delete(Student student);
    List<Student> findAll();
    List<Student> findAllStudentsForDepartment(Long idDepart);

}
