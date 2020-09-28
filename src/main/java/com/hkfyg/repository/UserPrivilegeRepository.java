package com.hkfyg.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.UserPrivilege;

 
@Transactional
public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege, Long>{  
	UserPrivilege findByName(String name);
}