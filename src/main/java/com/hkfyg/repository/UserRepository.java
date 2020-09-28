package com.hkfyg.repository;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.User;

 
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{  
//	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String Email);
	
	Boolean existsByEmail(String email);
	
}