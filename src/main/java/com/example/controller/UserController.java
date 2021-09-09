package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JWAuthentication;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.UserService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/all", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllProduct(){
		List<User> listuser = userService.getAllUser();
		return new ResponseEntity<List<User>>(listuser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id/{username}", method=RequestMethod.GET)
	public ResponseEntity<UserDetails> loaduserbyname(@PathVariable String username){
		UserDetails user = userService.loadUserByUsername(username);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
	
	
	
}
