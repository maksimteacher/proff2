package service;

import java.util.List;

import domain.School;

public interface SchoolService {
	School getSchool(Long id);
	void addSchool(School school);
	void updateSchool(School school);
	void deleteSchool(School school);
	List<School> getAllSchools();
}
