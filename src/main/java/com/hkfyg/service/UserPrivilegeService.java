package com.hkfyg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkfyg.model.entity.UserPrivilege;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.UserPrivilegeRepository;

@Service
@Transactional
public class UserPrivilegeService {

	@Autowired
	UserPrivilegeRepository userPrivilegeRepository;

	Logger logger = LoggerFactory.getLogger(UserPrivilegeService.class);

	public WebServiceResult createPrivilegeIfNotFound(String name) {
		logger.info("createUserPrivilege() started: " + name);
		WebServiceResult wsr = new WebServiceResult();
		try {
			UserPrivilege privilege = userPrivilegeRepository.findByName(name);
			if (privilege == null && name != null && !name.isEmpty()) {
				privilege = new UserPrivilege();
				privilege.setName(name);
				userPrivilegeRepository.save(privilege);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("createPrivilegeIfNotFound() ended successfully.");
			} else {
				wsr.setMsg("found exist privilege");
				wsr.setStatus(false);
				logger.info("createPrivilegeIfNotFound() ended and found exist privilege.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createPrivilegeIfNotFound() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<UserPrivilege> getUserPrivilegeList() {
		logger.info("getAllUserPrivilegeList() started.");	
		List<UserPrivilege> userPrivilegeList = userPrivilegeRepository.findAll();
		logger.info("getUserPrivilegeList() ended with userPrivilegeList size - " + userPrivilegeList.size());
		return userPrivilegeList;
	}

	public WebServiceResult updateUserPrivilege(UserPrivilege userPrivilege) {
		logger.info("updateUserPrivilege() started: " + userPrivilege);
		WebServiceResult wsr = new WebServiceResult();
		try {
			if (userPrivilege != null && userPrivilege.getId() != null) {
				userPrivilegeRepository.save(userPrivilege);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateUserPrivilege() ended successfully.");
			} else {
				wsr.setMsg("privilege cannot be found");
				wsr.setStatus(false);
				logger.info("updateUserPrivilege() ended and privilege cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateUserPrivilege() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
}
