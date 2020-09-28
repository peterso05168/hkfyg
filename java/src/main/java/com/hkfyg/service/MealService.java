package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hkfyg.exception.MealCategoryNotExistException;
import com.hkfyg.exception.MealEquipmentNotExistException;
import com.hkfyg.model.dto.CreateMealDTO;

import com.hkfyg.model.entity.Meal;
import com.hkfyg.model.entity.MealCategory;
import com.hkfyg.model.entity.MealEquipment;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.MealCategoryRepository;
import com.hkfyg.repository.MealEquipmentRepository;
import com.hkfyg.repository.MealRepository;

@Service
@Transactional
public class MealService {

	@Autowired
	MealRepository mealRepository;

	@Autowired
	MealCategoryRepository mealCategoryRepository;

	@Autowired
	MealEquipmentRepository mealEquipmentRepository;

	Logger logger = LoggerFactory.getLogger(MealService.class);

	public WebServiceResult createMeal(CreateMealDTO createMealDTO) {
		logger.info("createMeal() started: " + createMealDTO);
		WebServiceResult wsr = new WebServiceResult();
		try {
			Meal meal = convertDTOtoEoWithMealCategory(createMealDTO);
			meal = convertDTOtoEoWithMealEquipment(meal, createMealDTO.getMealEquipmentId());
			meal.setCreatedDateTime(new Date());
			meal.setUpdatedDateTime(new Date());
			mealRepository.save(meal);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createMeal() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createMeal() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<Meal> getMealList() {
		logger.info("getMealList() started.");
		List<Meal> mealList = mealRepository.findAll();
		logger.info("getMealList() ended with mealList size - " + mealList.size());
		return mealList;
	}

	public WebServiceResult deleteMeal(long id) {
		logger.info("deleteMeal() started with meal Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		Meal meal = mealRepository.findById(id).orElse(null);
		if (meal != null) {
			try {
				meal.setExpiryDate(new Date());
				meal.setUpdatedDateTime(new Date());
				mealRepository.save(meal);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteMeal() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteMeal() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteMeal() ended, no meal associate with id - " + id);
		}

		return wsr;
	}

	public WebServiceResult updateMeal(@ModelAttribute Meal meal) {
		logger.info("updateMeal() started: " + meal);
		Meal oldMeal = mealRepository.findById(meal.getId()).orElse(null);
		WebServiceResult wsr = new WebServiceResult();
		try {
			if (meal != null && oldMeal != null) {
				meal.setCreatedDateTime(oldMeal.getCreatedDateTime());
				meal.setUpdatedDateTime(new Date());
				mealRepository.save(meal);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateMeal() ended successfully.");
			} else {
				wsr.setMsg("meal cannot be found");
				wsr.setStatus(false);
				logger.info("updateMeal() ended and meal cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateMeal() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
	
	public List<Meal> getMealBySearch(CreateMealDTO createMealDTO) {
		logger.info("getMealBySearch() started.");		
		List<Meal> mealList = mealRepository.findAllByMealTypeContainingAndMealCategoryIdAndNameContainingAndExtra(createMealDTO.getMealType(), createMealDTO.getMealCategoryId(), createMealDTO.getName(), createMealDTO.isExtra());
		logger.info("getMealBySearch() ended with mealList size - " + mealList.size());
		return mealList;
	}

	public Meal convertDTOtoEoWithMealCategory(CreateMealDTO createMealDTO) throws MealCategoryNotExistException {
		if (createMealDTO.getMealCategoryId() != null) {
			Optional<MealCategory> mealCategory = mealCategoryRepository.findById(createMealDTO.getMealCategoryId());
			if (mealCategory.isPresent()) {
				Meal meal = new Meal();
				meal.setName(createMealDTO.getName());
				meal.setMealType(createMealDTO.getMealType());
				meal.setMinQuantity(createMealDTO.getMinQuantity());
				meal.setPriority(createMealDTO.getPriority());
				meal.setPrice(createMealDTO.getPrice());
				meal.setOtcPrice(createMealDTO.getOtcPrice());
				meal.setAllowPublic(createMealDTO.isAllowPublic());
				meal.setDescription(createMealDTO.getDescription());
				meal.setUnit(createMealDTO.getUnit());
				meal.setQuantity(createMealDTO.getQuantity());
				meal.setExtra(createMealDTO.isExtra());
				meal.setMealCategory(mealCategory.get());
				return meal;
			}
		}
		throw new MealCategoryNotExistException(MealCategoryNotExistException.MEAL_CATEGORY_NOT_EXIST_EXCEPTION);
	}

	public Meal convertDTOtoEoWithMealEquipment(Meal meal, Long mealEquipmentId) throws MealEquipmentNotExistException {
		if (mealEquipmentId != null) {
			Optional<MealEquipment> mealEquipment = mealEquipmentRepository.findById(mealEquipmentId);
			if (mealEquipment.isPresent()) {
				meal.setMealEquipment(mealEquipment.get());
				return meal;
			}
		}
		throw new MealEquipmentNotExistException(MealEquipmentNotExistException.MEAL_EQUIPMENT_NOT_EXIST_EXCEPTION);
	}
}
