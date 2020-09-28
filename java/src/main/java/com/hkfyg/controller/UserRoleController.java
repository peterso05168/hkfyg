package com.hkfyg.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkfyg.model.dto.CreateUserRoleDTO;
import com.hkfyg.model.entity.UserRole;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.UserRoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("userRole")
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;
	 
	Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	@PostMapping("/createUserRole")
	public WebServiceResult createUserRole(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
		return userRoleService.createUserRoleIfNotFound(createUserRoleDTO);	
	}
	
	@GetMapping("/getAllUserRoleList")
	public List<UserRole> getAllUserRoleList() {
		return userRoleService.getUserRoleList();
	}
	
	@PostMapping("/updateUserRole")
	public WebServiceResult updateUserRole(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
		return userRoleService.updateUserRole(createUserRoleDTO);	
	}
	
	//Currently not allow to delete
	@PostMapping(path = "/deleteUserRole")
	public WebServiceResult deleteUserRole(long id) {		
		logger.info("deleteUserRole() started with UserRole Id - " + id);
		return null;
	}
}
