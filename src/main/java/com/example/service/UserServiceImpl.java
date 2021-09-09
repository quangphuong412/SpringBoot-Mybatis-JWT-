package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo UserRepo;
	
	public List<User> getAllUser(){
		return UserRepo.getAllUser();
	}
	
	@Override
	public int addNewUser(User user) {
		String encodedPwd = passwordEncoder().encode(user.getPassword());
		user.setPassword(encodedPwd);
		return UserRepo.addNewUser(user);
		
	}
	
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		return UserRepo.loadUserByUsername(username);
	}
	

}
