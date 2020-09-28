package com.hkfyg.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hkfyg.model.entity.MealEquipment;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.MealEquipmentRepository;

@Service
@Transactional
public class MealEquipmentService {

	@Autowired
	MealEquipmentRepository mealEquipmentRepository;

	Logger logger = LoggerFactory.getLogger(MealEquipmentService.class);

	public WebServiceResult createMealEquipment(@ModelAttribute MealEquipment mealEquipment) {
		logger.info("createMealEquipment() started: " + mealEquipment);
		WebServiceResult wsr = new WebServiceResult();
		try {
			mealEquipment.setCreatedDateTime(new Date());
			mealEquipment.setUpdatedDateTime(new Date());
			mealEquipmentRepository.save(mealEquipment);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createMealEquipment() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createMealEquipment() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<MealEquipment> getMealEquipmentList() {
		logger.info("getMealEquipmentList() started.");			
		List<MealEquipment> mealEquipmentList = mealEquipmentRepository.findAll();
		logger.info("getMealEquipmentList() ended with mealEquipmentList size - " + mealEquipmentList.size());
		return mealEquipmentList;
	}

	public WebServiceResult deleteMealEquipment(long id) {
		logger.info("deleteMealEquipment() started with mealEquipment Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		MealEquipment mealEquipment = mealEquipmentRepository.findById(id).orElse(null);
		if (mealEquipment != null) {
			try {
				mealEquipment.setExpiryDate(new Date());
				mealEquipment.setUpdatedDateTime(new Date());
				mealEquipmentRepository.save(mealEquipment);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteMealEquipment() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteMealEquipment() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteMealEquipment() ended, no mealEquipment associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updateMealEquipment(@ModelAttribute MealEquipment mealEquipment) {
		logger.info("updateMealEquipment() started: " + mealEquipment);
		MealEquipment oldMealEquipment = mealEquipmentRepository.findById(mealEquipment.getId()).orElse(null);
		WebServiceResult wsr = new WebServiceResult();
		try {
			if (mealEquipment != null && oldMealEquipment != null) {
				mealEquipment.setCreatedDateTime(oldMealEquipment.getCreatedDateTime());
				mealEquipment.setUpdatedDateTime(new Date());
				mealEquipmentRepository.save(mealEquipment);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateMealEquipment() ended successfully.");
			} else {
				wsr.setMsg("mealEquipment cannot be found");
				wsr.setStatus(false);
				logger.info("updateMealEquipment() ended and mealEquipment cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateMealEquipment() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
	
	public List<MealEquipment> getMealEquipmentBySearch(MealEquipment mealEquipment) {
		logger.info("getMealEquipmentBySearch() started.");		
		List<MealEquipment> mealEquipmentList = mealEquipmentRepository.findAllByNameContaining(mealEquipment.getName());
		logger.info("getMealEquipmentBySearch() ended with mealEquipmentList size - " + mealEquipmentList.size());
		return mealEquipmentList;
	}
}
