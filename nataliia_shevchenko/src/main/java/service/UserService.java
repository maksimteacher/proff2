package service;

import java.util.List;

import domain.User;

public interface UserService {
	void addNewUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> getAllUsers();

}
