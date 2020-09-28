package com.hkfyg.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.UserRole;

 
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{  
	UserRole findByName(String name);
}