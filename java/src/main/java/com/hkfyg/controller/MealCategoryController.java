package com.hkfyg.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkfyg.model.dto.CreateMealDTO;
import com.hkfyg.model.entity.Meal;
import com.hkfyg.model.entity.MealCategory;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.MealCategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("mealCategory")
public class MealCategoryController {
	@Autowired
	MealCategoryService mealCategoryService;
	 
	Logger logger = LoggerFactory.getLogger(MealCategoryController.class);
	
	@PostMapping("/createMealCategory")
	public WebServiceResult createMealCategory(@RequestBody MealCategory mealCategory) {
		return mealCategoryService.createMealCategory(mealCategory);	
	}
	
	@GetMapping("/getMealCategoryList")
	public List<MealCategory> getMealCategoryList() {	
		return mealCategoryService.getMealCategoryList();
	}

	@PostMapping("/updateMealCategory")
	public WebServiceResult updateUserRole(@RequestBody MealCategory mealCategory) {
		return mealCategoryService.updateMealCategory(mealCategory);	
	}
	
	@PostMapping("/getMealCategoryBySearch")
	public List<MealCategory> getMealCategoryBySearch(@RequestBody MealCategory mealCategory) {	
		return mealCategoryService.getMealCategoryBySearch(mealCategory);
	}
	
	//Currently does not allow delete
	@PostMapping("/deleteMealCategory")
	public WebServiceResult deleteMealCategory(long id) {		
		return null;
		//return mealCategoryService.deleteMealCategory(id);
	}
}
