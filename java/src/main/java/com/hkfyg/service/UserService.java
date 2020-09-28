package com.hkfyg.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hkfyg.model.dto.RegisterDTO;
import com.hkfyg.model.entity.User;
import com.hkfyg.model.entity.UserRole;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.UserRepository;
import com.hkfyg.repository.UserRoleRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public List<User> getUserList() {
		List<User> userList = userRepository.findAll();
		logger.info("getUserList() ended with getUserList size - " + userList.size());
		return userList;
	}
	
	public WebServiceResult handleRegisterUser(RegisterDTO registerDTO) {
		WebServiceResult wsr = new WebServiceResult();
		if (userRepository.existsByEmail(registerDTO.getEmail())) {
			wsr.setMsg("Error: Email is already in use!");
			wsr.setStatus(false);
			return wsr;
		}
		User user = new User(registerDTO.getFirstName(), registerDTO.getLastName(), registerDTO.getEmail(),
							 encoder.encode(registerDTO.getPassword()));

		Set<UserRole> roles = new HashSet<>();
		UserRole userRole = roleRepository.findByName("user");
		roles.add(userRole);

		user.setRoles(roles);
		userRepository.save(user);

		wsr.setMsg(WebServiceResult.SUCCESS);
		wsr.setStatus(true);

		return wsr;
	}
}
