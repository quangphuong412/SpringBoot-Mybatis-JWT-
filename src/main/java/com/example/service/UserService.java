package com.example.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.entity.User;

public interface UserService extends UserDetailsService{
	
	List<User> getAllUser();
	int addNewUser(User user);
}
