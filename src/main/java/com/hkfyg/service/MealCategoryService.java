package com.hkfyg.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hkfyg.model.entity.MealCategory;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.MealCategoryRepository;

@Service
@Transactional
public class MealCategoryService {

	@Autowired
	MealCategoryRepository mealCategoryRepository;

	Logger logger = LoggerFactory.getLogger(MealCategoryService.class);

	public WebServiceResult createMealCategory(@ModelAttribute MealCategory mealCategory) {
		logger.info("createMealCategory() started: " + mealCategory);
		WebServiceResult wsr = new WebServiceResult();
		try {
			mealCategory.setCreatedDateTime(new Date());
			mealCategory.setUpdatedDateTime(new Date());
			mealCategoryRepository.save(mealCategory);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createMealCategory() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createMealCategory() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<MealCategory> getMealCategoryList() {
		logger.info("getMealCategoryList() started.");			
		List<MealCategory> mealCategoryList = mealCategoryRepository.findAll();
		logger.info("getMealCategoryList() ended with mealCategoryList size - " + mealCategoryList.size());
		return mealCategoryList;
	}

	public WebServiceResult deleteMealCategory(long id) {
		logger.info("deleteMealCategory() started with mealCategory Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		MealCategory mealCategory = mealCategoryRepository.findById(id).orElse(null);
		if (mealCategory != null) {
			try {
				mealCategory.setExpiryDate(new Date());
				mealCategory.setUpdatedDateTime(new Date());
				mealCategoryRepository.save(mealCategory);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteMealCategory() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteMealCategory() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteMealCategory() ended, no mealCategory associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updateMealCategory(@ModelAttribute MealCategory mealCategory) {
		logger.info("updateMealCategory() started: " + mealCategory);
		MealCategory oldMealCategory = mealCategoryRepository.findById(mealCategory.getId()).orElse(null);
		WebServiceResult wsr = new WebServiceResult();
		try {
			if (mealCategory != null && oldMealCategory != null) {
				mealCategory.setCreatedDateTime(oldMealCategory.getCreatedDateTime());
				mealCategory.setUpdatedDateTime(new Date());
				mealCategoryRepository.save(mealCategory);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateMealCategory() ended successfully.");
			} else {
				wsr.setMsg("mealCategory cannot be found");
				wsr.setStatus(false);
				logger.info("updateMealCategory() ended and mealCategory cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateMealCategory() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
	
	public List<MealCategory> getMealCategoryBySearch(MealCategory mealCategory) {
		logger.info("getMealCategoryBySearch() started.");		
		List<MealCategory> mealCategoryList = mealCategoryRepository.findAllByNameContaining(mealCategory.getName());
		logger.info("getMealCategoryBySearch() ended with mealCategoryList size - " + mealCategoryList.size());
		return mealCategoryList;
	}
}
