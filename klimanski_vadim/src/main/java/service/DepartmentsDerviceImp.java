package service;

import java.util.List;

import domain.Contructor;
import dao.DepatmentsDao;
import domain.Departments;

public class DepartmentsDerviceImp implements DepartmentsService{
DepatmentsDao dao;

public DepartmentsDerviceImp(DepatmentsDao dao) {
	this.dao = dao;
}

@Override
public Departments get(Long id){
	return dao.read(id);
}
@Override
public void add(Departments department) {
	dao.create(department);
}

@Override
public List<Departments> getAllDepartment() {
	return dao.findAll();
}



}
