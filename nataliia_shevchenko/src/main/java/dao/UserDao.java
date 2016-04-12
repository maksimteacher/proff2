package dao;

import java.util.List;

import domain.User;

public interface UserDao {
	
	Long create(User user);
	User read(Long id);
	void update(User user);
	void delete(User user);
	List<User> findAll();

}
