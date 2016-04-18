package service;

import java.util.List;

import dao.StudentsDao;
import domain.Departments;
import domain.Students;

public class StudentServiceImp implements StudentService{
	StudentsDao dao;
	public StudentServiceImp(StudentsDao dao){
		this.dao = dao;
	}
	
	@Override
	public Students get (long id){
		return dao.read(id);
			}
	@Override
	public void add(Students students){
		dao.create(students);
	}
	@Override
	public List<Students> findAll() {
		return dao.findAll();
	}
}
