package dao;

import java.util.List;

import domain.Departments;

public interface DepatmentsDao {

	Long create(Departments departments);

	Departments read(Long id);

	void update(Departments departments);

	void delete(Departments departments);

	List<Departments> findAll();

}
