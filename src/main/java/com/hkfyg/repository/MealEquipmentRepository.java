package com.hkfyg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.MealEquipment;

@Transactional
public interface MealEquipmentRepository extends JpaRepository<MealEquipment, Long>{  
	List<MealEquipment> findAllByNameContaining(String name);
}