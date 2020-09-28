package com.hkfyg.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.SystemParam;


 
@Transactional
public interface SystemParamRepository extends JpaRepository<SystemParam, Long>{  
	public List<SystemParam> findByCode(String code);
}