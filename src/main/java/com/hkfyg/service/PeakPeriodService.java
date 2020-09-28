package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkfyg.model.entity.PeakPeriod;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.PeakPeriodRepository;

@Service
@Transactional
public class PeakPeriodService {
	@Autowired
	PeakPeriodRepository peakPeriodRepository;
	
	Logger logger = LoggerFactory.getLogger(PeakPeriodService.class);
	
	public WebServiceResult createPeakPeriod(PeakPeriod peakPeriod) {
		logger.info("createPeakPeriod() started: " + peakPeriod);
		WebServiceResult wsr = new WebServiceResult();
		try {
			peakPeriod.setCreatedDateTime(new Date());
			peakPeriodRepository.save(peakPeriod);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createPeakPeriod() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createPeakPeriod() ended with exception - " + e.getMessage());
		}

		return wsr;
		
	}
	
	public List<PeakPeriod> getPeakPeriodList() {
		logger.info("getPeakPeriodList() started.");			
		List<PeakPeriod> peakPeriodList = peakPeriodRepository.findAll();
		logger.info("getPeakPeriodList() ended with getPeakPeriodList size - " + peakPeriodList.size());
		return peakPeriodList;
	}
	
	public List<PeakPeriod> getPeakPeriodBySearch(PeakPeriod peakPeriod) {
		logger.info("getPeakPeriodBySearch() started.");		
		
		List<PeakPeriod> peakPeriodList = null;
		
		String campType = peakPeriod.getCampType();
		Date peakDateFrom = peakPeriod.getPeakDateFrom();
		Date peakDateTo = peakPeriod.getPeakDateTo();
		try {
			peakPeriodList = peakPeriodRepository.findAllByCampTypeAndPeakDateFromGreaterThanAndPeakDateToLessThan(campType, peakDateFrom, peakDateTo);
			logger.info("getPeakPeriodBySearch() ended with getPeakPeriodList size - " + peakPeriodList.size());

		} catch (Exception e) {
			
			
			logger.info("getPeakPeriodBySearch() ended with exception - " + e.getMessage());
		}
		
		return peakPeriodList;
	}
	
	public WebServiceResult deletePeakPeriod(long id) {
		logger.info("deletePeakPeriod() started with id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		PeakPeriod peakPeriod = peakPeriodRepository.findById(id).orElse(null);
		if (peakPeriod != null) {
			try {
				peakPeriod.setExpiryDate(new Date());
				peakPeriodRepository.save(peakPeriod);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deletePeakPeriod() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deletePeakPeriod() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deletePeakPeriod() ended, no Peak Period associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updatePeakPeriod(PeakPeriod peakPeriod) {
		logger.info("updatePeakPerod() started: " + peakPeriod);
		WebServiceResult wsr = new WebServiceResult();
		Long id = peakPeriod.getId();
		try {
			Optional<PeakPeriod> list = peakPeriodRepository.findById(id);
			if (id != null) {
				PeakPeriod peakPeriodList = list.get();
				peakPeriodList.setCampType(peakPeriod.getCampType());
				peakPeriodList.setPeakDateFrom(peakPeriod.getPeakDateFrom());
				peakPeriodList.setPeakDateTo(peakPeriod.getPeakDateTo());
				peakPeriodRepository.save(peakPeriodList);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updatePeakPerod() ended successfully.");
			} else {
				wsr.setMsg("id given cannot be found");
				wsr.setStatus(false); 
				logger.info("updatePeakPerod() ended and id given cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updatePeakPerod() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
	
}
