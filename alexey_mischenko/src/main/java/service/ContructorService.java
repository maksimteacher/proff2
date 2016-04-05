package service;

import java.util.List;

import domain.Contructor;

public interface ContructorService {
	Contructor get(Long id);
	void add(Contructor contructor);
	List<Contructor> getAllContructors();
}
