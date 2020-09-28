package com.hkfyg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.Facility;

 
@Transactional
public interface FacilityRepository extends JpaRepository<Facility, Long>{  
	List<Facility> findAllByNameContainingAndFacilityTypeIdAndAllowActivity(String name,long facilityTypeId, boolean AllowActivity);
}