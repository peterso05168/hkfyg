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

import com.hkfyg.model.entity.OtherExpensesCategory;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.OtherExpensesCategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("otherExpensesCategory")
public class OtherExpensesCategoryController {
	
	@Autowired
	OtherExpensesCategoryService otherExpensesCategoryService;
	 
	Logger logger = LoggerFactory.getLogger(BedController.class);
	
	@PostMapping("/createOtherExpensesCategory")
	public WebServiceResult createOtherExpensesCategory(@RequestBody OtherExpensesCategory otherExpensesCategory) {
		return otherExpensesCategoryService.createOtherExpenseCategory(otherExpensesCategory);	
	}
	
	@GetMapping("/getOtherExpensesCategory")
	public List<OtherExpensesCategory> getOtherExpensesCategoryList() {	
		return otherExpensesCategoryService.getOtherExpensesCategoryList();
	}
	
	@GetMapping("/getOtherExpensesCategoryBySearch")
	public List<OtherExpensesCategory> getOtherExpensesCategoryBySearch(@RequestBody OtherExpensesCategory otherExpensesCategory) {	
		return otherExpensesCategoryService.getOtherExpensesCategoryBySearch(otherExpensesCategory);
	}
	
	//Currently does not allow delete
		@PostMapping("/deleteOtherExpensesCategory")
		public WebServiceResult deleteOtherExpensesCategory(@RequestBody long id) {		
			return null;
			//return bedService.deleteBed(id);
		}
		
		@PostMapping("/updateOtherExpensesCategory")
		public WebServiceResult updateUserRole(@RequestBody OtherExpensesCategory otherExpensesCategory) {
			return otherExpensesCategoryService.updateOtherExpensesCategory(otherExpensesCategory);	
		}

}
