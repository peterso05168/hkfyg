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

import com.hkfyg.model.dto.CreateFacilityDTO;
import com.hkfyg.model.dto.CreateMealDTO;
import com.hkfyg.model.entity.Facility;
import com.hkfyg.model.entity.Meal;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.MealService;

@CrossOrigin("*")
@RestController
@RequestMapping("meal")
public class MealController {
	@Autowired
	MealService mealService;
	 
	Logger logger = LoggerFactory.getLogger(MealController.class);
	
	@PostMapping("/createMeal")
	public WebServiceResult createMeal(@RequestBody CreateMealDTO createMealDTO) {
		return mealService.createMeal(createMealDTO);	
	}
	
	@GetMapping("/getMealList")
	public List<Meal> getMealList() {	
		return mealService.getMealList();
	}

	@PostMapping("/updateMeal")
	public WebServiceResult updateUserRole(@RequestBody Meal meal) {
		return mealService.updateMeal(meal);	
	}
	
	@PostMapping("/getMealBySearch")
	public List<Meal> getMealBySearch(@RequestBody CreateMealDTO createMealDTO) {	
		return mealService.getMealBySearch(createMealDTO);
	}
	
	//Currently does not allow delete
	@PostMapping("/deleteMeal")
	public WebServiceResult deleteMeal(long id) {		
		return null;
		//return mealService.deleteMeal(id);
	}
}
