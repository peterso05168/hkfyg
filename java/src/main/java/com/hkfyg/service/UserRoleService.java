package com.hkfyg.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkfyg.model.dto.CreateUserRoleDTO;
import com.hkfyg.model.entity.UserPrivilege;
import com.hkfyg.model.entity.UserRole;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.UserPrivilegeRepository;
import com.hkfyg.repository.UserRoleRepository;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserPrivilegeRepository userPrivilegeRepository;

	Logger logger = LoggerFactory.getLogger(UserRoleService.class);

	public WebServiceResult createUserRoleIfNotFound(CreateUserRoleDTO createUserRoleDTO) {
		logger.info("createUserRole() started: " + createUserRoleDTO);
		WebServiceResult wsr = new WebServiceResult();
		String userRoleName = createUserRoleDTO.getUserRoleName();
		List<Long> privilegesIdList = createUserRoleDTO.getPrivilegesIdList();
		try {
			UserRole userRole = userRoleRepository.findByName(userRoleName);
			if (userRole == null && userRoleName != null && !userRoleName.isEmpty()) {
				Collection<UserPrivilege> userPrivileges = userPrivilegeRepository.findAllById(privilegesIdList);
				userRole = new UserRole();
				userRole.setName(userRoleName);
				userRole.setUserPrivileges(userPrivileges);
				userRoleRepository.save(userRole);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("createUserRoleIfNotFound() ended successfully.");
			} else {
				wsr.setMsg("found existing user role.");
				wsr.setStatus(false);
				logger.info("createUserRoleIfNotFound() ended and found existing userRole.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createUserRoleIfNotFound() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<UserRole> getUserRoleList() {
		logger.info("getAllUserRoleList() started.");
		List<UserRole> userRoleList = userRoleRepository.findAll();
		logger.info("getUserRoleList() ended with userRoleList size - " + userRoleList.size());
		return userRoleList;
	}

	public WebServiceResult updateUserRole(CreateUserRoleDTO createUserRoleDTO) {
		logger.info("updateUserRole() started: " + createUserRoleDTO);
		WebServiceResult wsr = new WebServiceResult();
		String userRoleName = createUserRoleDTO.getUserRoleName();
		List<Long> privilegesIdList = createUserRoleDTO.getPrivilegesIdList();
		try {
			UserRole userRole = userRoleRepository.findByName(userRoleName);
			if (userRole != null && userRoleName != null && !userRoleName.isEmpty()) {
				Collection<UserPrivilege> userPrivileges = userPrivilegeRepository.findAllById(privilegesIdList);
				userRole.setUserPrivileges(userPrivileges);
				userRoleRepository.save(userRole);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateUserRole() ended successfully.");
			} else {
				wsr.setMsg("user role given cannot be found");
				wsr.setStatus(false);
				logger.info("updateUserRole() ended and userRoleName given cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateUserRole() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
}
