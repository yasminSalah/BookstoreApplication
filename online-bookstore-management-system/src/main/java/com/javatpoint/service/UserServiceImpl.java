package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.repository.UserRepository;
import com.javatpoint.exception.ResourceNotFoundException;
import com.javatpoint.model.User;

@Service
public class UserServiceImpl implements UserService{

	
	 @Autowired
	    private UserRepository userRepository;

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	    }

	    public User addUser(User user) {
	        return userRepository.save(user);
	    }

	    public User updateUser(Long id, User user) {
	        User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

	        existingUser.setUsername(user.getUsername());
	        existingUser.setPassword(user.getPassword());
	        existingUser.setRole(user.getRole());

	        return userRepository.save(existingUser);
	    }

	    public void deleteUser(Long id) {
	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	        userRepository.delete(user);
	    }
}
