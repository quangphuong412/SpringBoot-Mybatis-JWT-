package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.mapper.UserMapper;

@Repository
public class UserRepoImpl implements UserRepo{
	
	@Autowired
	private UserMapper UserMapper;
	
	public List<User> getAllUser(){
		return UserMapper.getAllUser();
	}
	
	public User loadUserByUsername(String username) {
		return UserMapper.loadUserByUsername(username);
	}
	
	public int addNewUser(User user) {
		return UserMapper.addNewUser(user);
	}
}
