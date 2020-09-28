package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hkfyg.model.entity.OtherExpensesCategory;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.OtherExpensesCategoryRepository;

@Service
@Transactional
public class OtherExpensesCategoryService {

	@Autowired
	OtherExpensesCategoryRepository otherExpenseCategoryRepository;
	
	Logger logger = LoggerFactory.getLogger(OtherExpensesCategoryService.class);
	
	public WebServiceResult createOtherExpenseCategory(OtherExpensesCategory otherExpensesCategory) {
		logger.info("createOtherExpensesCategory() started: " + otherExpensesCategory);
		WebServiceResult wsr = new WebServiceResult();
		try {
			otherExpensesCategory.setCreatedDateTime(new Date());
			otherExpenseCategoryRepository.save(otherExpensesCategory);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createOtherExpensesCategory() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createOtherExpensesCategory() ended with exception - " + e.getMessage());
		}

		return wsr;
		
	}
	
	public List<OtherExpensesCategory> getOtherExpensesCategoryList() {
		logger.info("getOtherExpensesCategoryList() started.");			
		List<OtherExpensesCategory> otherExpensesCategoryList = otherExpenseCategoryRepository.findAll();
		logger.info("getOtherExpensesCategoryList() ended with OtherExpensesCategoryList size - " + otherExpensesCategoryList.size());
		return otherExpensesCategoryList;
	}
	
	public List<OtherExpensesCategory> getOtherExpensesCategoryBySearch(OtherExpensesCategory otherExpensesCategory) {
		logger.info("getOtherExpensesCategoryBySearch() started.");		
		List<OtherExpensesCategory> otherExpensesCategoryList = otherExpenseCategoryRepository.findAllByTypeContainingAndCategoryContaining(otherExpensesCategory.getType(), otherExpensesCategory.getCategory());
		logger.info("getOtherExpensesCategoryBySearch() ended with OtherExpensesCategoryList size - " + otherExpensesCategoryList.size());
		return otherExpensesCategoryList;
	}
	
	public WebServiceResult deleteOtherExpensesCategory(long id) {
		logger.info("deleteOtherExpensesCategory() started with Other Expenses Category Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		OtherExpensesCategory otherExpensesCategory = otherExpenseCategoryRepository.findById(id).orElse(null);
		if (otherExpensesCategory != null) {
			try {
				otherExpensesCategory.setExpiryDate(new Date());
				otherExpenseCategoryRepository.save(otherExpensesCategory);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteOtherExpensesCategory() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteOtherExpensesCategory() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteOtherExpensesCategory() ended, no Other Expenses Category associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updateOtherExpensesCategory(OtherExpensesCategory otherExpensesCategory) {
		logger.info("updateOtherExpensesCategory() started: " + otherExpensesCategory);
		WebServiceResult wsr = new WebServiceResult();
		Long id = otherExpensesCategory.getId();
		try {
			Optional<OtherExpensesCategory> list = otherExpenseCategoryRepository.findById(id);
			if (id != null) {
				OtherExpensesCategory otherExpensesCategoryList = list.get();
				otherExpensesCategoryList.setType(otherExpensesCategory.getType());
				otherExpensesCategoryList.setPrice(otherExpensesCategory.getPrice());
				otherExpensesCategoryList.setCategory(otherExpensesCategory.getCategory());
				otherExpenseCategoryRepository.save(otherExpensesCategoryList);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateOtherExpensesCategory() ended successfully.");
			} else {
				wsr.setMsg("id given cannot be found");
				wsr.setStatus(false); 
				logger.info("updateOtherExpensesCategory() ended and id given cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateOtherExpensesCategory() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
}
