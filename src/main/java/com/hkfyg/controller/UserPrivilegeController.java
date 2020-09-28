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

import com.hkfyg.model.entity.UserPrivilege;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.UserPrivilegeService;

@CrossOrigin("*")
@RestController
@RequestMapping("userPrivilege")
public class UserPrivilegeController {
	@Autowired
	UserPrivilegeService userPrivilegeService;
	 
	Logger logger = LoggerFactory.getLogger(UserPrivilegeController.class);
	
	@PostMapping("/createUserPrivilege")
	public WebServiceResult createUserPrivilegeIfNotFound(@RequestBody UserPrivilege userPrivilege) {
		return userPrivilegeService.createPrivilegeIfNotFound(userPrivilege.getName());	
	}
	
	@GetMapping("/getAllUserPrivilegeList")
	public List<UserPrivilege> getAllUserPrivilegeList() {			
		return userPrivilegeService.getUserPrivilegeList();
	}
	
	@PostMapping("/updateUserPrivilege")
	public WebServiceResult updateUserPrivilege(@RequestBody UserPrivilege userPrivilege) {
		return userPrivilegeService.updateUserPrivilege(userPrivilege);	
	}
	
	//Currently not allow to delete
	@PostMapping("/deleteUserPrivilege")
	public WebServiceResult deleteUserPrivilege(long id) {		
		logger.info("deleteUserPrivilege() started with UserPrivilege Id - " + id);
		return null;
	}
}
