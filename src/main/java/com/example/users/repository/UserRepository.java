package com.example.users.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.users.dto.UserDTO;
import com.example.users.entities.User;


@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
	

	List<User> findAllByEmail(String email);
	
	User findByUsername(String username);

	User findByEmail(String email);

	UserDTO findUserByUsername(String username);
}
