
package com.hkfyg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.FacilityType;

@Transactional
public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long>{  
	List<FacilityType> findAllByNameContaining(String name);
}