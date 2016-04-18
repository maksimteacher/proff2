package service;

import java.util.List;

import dao.StudentDaoImpl;
import domain.Student;

public class StudentServiceImpl implements StudentService{
	
	private StudentDaoImpl studDao;

	public StudentServiceImpl() {
		studDao = new StudentDaoImpl();
	}

	@Override
	public Student getStudent(Long id) {
		return studDao.read(id);
	}

	@Override
	public void addStudent(Student st) {
		studDao.create(st);
	}

	@Override
	public void updateStudent(Student st) {
		studDao.update(st);
	}

	@Override
	public void deleteStudent(Student st) {
		studDao.delete(st);
	}

	@Override
	public void addAll(List<Student> students) {
		for(Student s : students) {
			studDao.create(s);
		}
		
	}

	@Override
	public void deleteAll(List<Student> students) {
		for(Student s : students) {
			studDao.delete(s);
		}
		
	}

	@Override
	public List<Student> getAllDepartments() {
		return studDao.readAll();
	}

	public List<Student> getAllStudentsByDep(long idDep) {
		return studDao.findAllStudentsByDep(idDep);
	}

	public List<Student> getAllStudFromSchoolSortedByName(Long schoolId) {
		return studDao.findStudentsBySchoolSortedByName(schoolId);
	}

}
