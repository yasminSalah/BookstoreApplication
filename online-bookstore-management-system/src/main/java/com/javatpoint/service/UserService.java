package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.User;

public interface UserService {

	 List<User> getAllUsers();
	    User getUserById(Long id);
	    User addUser(User user);
	    User updateUser(Long id, User user);
	    void deleteUser(Long id);
}
