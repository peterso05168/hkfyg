package com.hkfyg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.MealCategory;

@Transactional
public interface MealCategoryRepository extends JpaRepository<MealCategory, Long>{  
	List<MealCategory> findAllByNameContaining(String name);
}