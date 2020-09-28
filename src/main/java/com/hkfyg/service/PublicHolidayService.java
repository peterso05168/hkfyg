package com.hkfyg.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkfyg.model.entity.OtherExpensesCategory;
import com.hkfyg.model.entity.PublicHoliday;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.OtherExpensesCategoryRepository;
import com.hkfyg.repository.PublicHolidayRepository;

@Service
@Transactional
public class PublicHolidayService {
	
	@Autowired
	PublicHolidayRepository publicHolidayRepository;
	
	Logger logger = LoggerFactory.getLogger(PublicHolidayService.class);
	
	public WebServiceResult createPublicHoliday(PublicHoliday publicHoliday) {
		logger.info("createPublicHoliday() started: " + publicHoliday);
		WebServiceResult wsr = new WebServiceResult();
		try {
			publicHoliday.setCreatedDateTime(new Date());
			publicHolidayRepository.save(publicHoliday);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createPublicHoliday() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createPublicHoliday() ended with exception - " + e.getMessage());
		}

		return wsr;
		
	}
	
	public List<PublicHoliday> getPublicHolidayList() {
		logger.info("getPublicHolidayList() started.");			
		List<PublicHoliday> publicHolidayList = publicHolidayRepository.findAll();
		logger.info("getPublicHolidayList() ended with getPublicHolidayList size - " + publicHolidayList.size());
		return publicHolidayList;
	}
	
	public List<PublicHoliday> getPublicHolidayBySearch(int year) {
		logger.info("getPublicHolidayBySearch() started.");		
		
		List<PublicHoliday> publicHolidayList = null;
		
		Date startDate;
		Date endDate;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-01-01");
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-12-31");
			publicHolidayList = publicHolidayRepository.findAllByDateBetween(startDate, endDate);
			logger.info("getPublicHolidayBySearch() ended with getPublicHolidayList size - " + publicHolidayList.size());

		} catch (ParseException e) {
			
			
			logger.info("getPublicHolidayBySearch() ended with exception - " + e.getMessage());
		}
		
		return publicHolidayList;
	}
	
	public WebServiceResult deletePublicHoliday(long id) {
		logger.info("deletePublicHoliday() started with id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		PublicHoliday publicHoliday = publicHolidayRepository.findById(id).orElse(null);
		if (publicHoliday != null) {
			try {
				publicHoliday.setExpiryDate(new Date());
				publicHolidayRepository.save(publicHoliday);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deletePublicHoliday() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deletePublicHoliday() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deletePublicHoliday() ended, no Public Holiday associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updatePublicHoliday(PublicHoliday publicHoliday) {
		logger.info("updatePublicHoliday() started: " + publicHoliday);
		WebServiceResult wsr = new WebServiceResult();
		Long id = publicHoliday.getId();
		try {
			Optional<PublicHoliday> list = publicHolidayRepository.findById(id);
			if (id != null) {
				PublicHoliday publicHolidayList = list.get();
				publicHolidayList.setDate(publicHoliday.getDate());
				publicHolidayList.setDescription(publicHoliday.getDescription());
				publicHolidayRepository.save(publicHolidayList);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updatePublicHoliday() ended successfully.");
			} else {
				wsr.setMsg("id given cannot be found");
				wsr.setStatus(false); 
				logger.info("updatePublicHoliday() ended and id given cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updatePublicHoliday() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
}
