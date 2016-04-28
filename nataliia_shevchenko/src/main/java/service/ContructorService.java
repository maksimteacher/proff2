package service;

import java.util.List;

import domain.Contructor;


public interface ContructorService {	
	//Contructor get(Long id);
	void addNewContructor(Contructor contructor);
	void updateContructor(Contructor contructor);
	void deleteContructor(Contructor contructor);
	List<Contructor> getAllContructors();
		 
}
