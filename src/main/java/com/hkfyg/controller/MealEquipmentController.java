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

import com.hkfyg.model.entity.MealCategory;
import com.hkfyg.model.entity.MealEquipment;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.MealEquipmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("mealEquipment")
public class MealEquipmentController {
	@Autowired
	MealEquipmentService mealEquipmentService;
	 
	Logger logger = LoggerFactory.getLogger(MealEquipmentController.class);
	
	@PostMapping("/createMealEquipment")
	public WebServiceResult createMealEquipment(@RequestBody MealEquipment mealEquipment) {
		return mealEquipmentService.createMealEquipment(mealEquipment);	
	}
	
	@GetMapping("/getMealEquipmentList")
	public List<MealEquipment> getMealEquipmentList() {	
		return mealEquipmentService.getMealEquipmentList();
	}

	@PostMapping("/updateMealEquipment")
	public WebServiceResult updateUserRole(@RequestBody MealEquipment mealEquipment) {
		return mealEquipmentService.updateMealEquipment(mealEquipment);	
	}
	
	@PostMapping("/getMealEquipmentBySearch")
	public List<MealEquipment> getMealEquipmentBySearch(@RequestBody MealEquipment mealEquipment) {	
		return mealEquipmentService.getMealEquipmentBySearch(mealEquipment);
	}
	
	//Currently does not allow delete
	@PostMapping("/deleteMealEquipment")
	public WebServiceResult deleteMealEquipment(long id) {		
		return null;
		//return mealEquipmentService.deleteMealEquipment(id);
	}
}
