package com.hkfyg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.Meal;

@Transactional
public interface MealRepository extends JpaRepository<Meal, Long>{  
	List<Meal> findAllByMealTypeContainingAndMealCategoryIdAndNameContainingAndExtra(String mealType,long mealCategoryId, String name, boolean extra);
}