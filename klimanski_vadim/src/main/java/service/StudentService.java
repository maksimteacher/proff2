package service;

import java.util.List;

import domain.Students;

public interface StudentService {

	Students get(long id);

	void add(Students students);

	List<Students> findAll();

}
