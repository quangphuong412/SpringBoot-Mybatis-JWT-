package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;

@Mapper
public interface UserMapper {
	
	List<User> getAllUser();
	int addNewUser(User user);
	User loadUserByUsername(String username);
	
}
