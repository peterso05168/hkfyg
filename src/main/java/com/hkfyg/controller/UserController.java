package com.hkfyg.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkfyg.model.dto.RegisterDTO;
import com.hkfyg.model.entity.User;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	 
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/createUser")
	public WebServiceResult createUser(@RequestBody User User) {
		logger.info("createUser() started: " + User);
		return null;	
	}
	
	@GetMapping("/getAllUserList")
	public List<User> getAllUserList() {
		logger.info("getAllUserList() started.");				
		return userService.getUserList();
	}
	
	@PostMapping("/updateUser")
	public WebServiceResult updateUser(@RequestBody User User) {
		logger.info("updateUser() started: " + User);
		return null;	
	}
	
	@PostMapping("/deleteUser")
	public WebServiceResult deleteUser(long id) {		
		logger.info("deleteUser() started with User Id - " + id);
		return null;
	}
	
	@PostMapping("/signup")
	public WebServiceResult registerUser(@Valid @RequestBody RegisterDTO signUpRequest) {
		return userService.handleRegisterUser(signUpRequest);
	}
}
