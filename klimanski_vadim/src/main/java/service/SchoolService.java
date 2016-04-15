package service;

import java.util.List;

import dao.SchoolDao;
import domain.Contructor;
import domain.School;

public class SchoolService implements SchoolServiceImp{
SchoolDao dao;
public SchoolService(SchoolDao dao){
	this.dao = dao;
}
@Override
public School get(Long id) {
	return dao.read(id);
}

@Override
public void add(School school) {
	dao.create(school);
}

@Override
public List<School> getAllSchool() {
	return dao.findAll();
}

}
