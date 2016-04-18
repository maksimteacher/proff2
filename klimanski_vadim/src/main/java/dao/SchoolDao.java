package dao;

import java.util.List;

import domain.School;

public interface SchoolDao {

	Long create(School school);

	School read(Long id);

	void update(School school);

	void delete(School school);

	List<School> findAll();

}
