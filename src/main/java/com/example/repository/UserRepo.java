package com.example.repository;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;

public interface UserRepo {
	
	List<User> getAllUser();
	int addNewUser(User user);
	User loadUserByUsername(String username);

}
