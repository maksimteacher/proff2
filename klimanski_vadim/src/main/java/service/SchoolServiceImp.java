package service;

import java.util.List;

import domain.School;

public interface SchoolServiceImp {

	School get(Long id);

	void add(School school);

	List<School> getAllSchool();

}
