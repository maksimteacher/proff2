package service;

import java.util.List;

import domain.Contructor;
import domain.Product;

public interface ContructorService {
	Contructor get(Long id);
	void add(Contructor contructor);
	void updateContructor(Contructor contructor);
	void deleteContructor(Contructor contructor);
	List<Contructor> getAllContructors(); 
}
