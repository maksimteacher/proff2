package dao;

import java.util.List;

import domain.Students;

public interface StudentsDao {

	Long create(Students students);

	Students read(Long id);

	void update(Students students);

	void delete(Students students);

	List<Students> findAll();

}
