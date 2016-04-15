package dao;

import java.util.List;

import domain.Contructor;
import domain.Product;
import domain.Students;

public interface ContructorDao {
	Long create(Contructor contructor);
	Contructor read(Long id);
	void update(Contructor contructor);
	void delete(Contructor contructor);
	List<Contructor> findAll();
	
}
