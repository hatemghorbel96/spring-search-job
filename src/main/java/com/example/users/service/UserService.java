package com.example.users.service;

import java.util.List;

import com.example.users.entities.User;



public interface UserService {
	


	
	User saveUser(User user);
	User updateUser(User u);
	User getUser(Long id);
	User findUserByUsername (String username);

	List<User> findAllUsers();

	User updatepasswordbyId(User u);
	

}
