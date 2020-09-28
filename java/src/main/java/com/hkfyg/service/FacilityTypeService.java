package com.hkfyg.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hkfyg.model.entity.FacilityType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.FacilityTypeRepository;

@Service
@Transactional
public class FacilityTypeService {

	@Autowired
	FacilityTypeRepository facilityTypeRepository;

	Logger logger = LoggerFactory.getLogger(FacilityTypeService.class);

	public WebServiceResult createFacilityType(@ModelAttribute FacilityType facilityType) {
		logger.info("createFacilityType() started: " + facilityType);
		WebServiceResult wsr = new WebServiceResult();
		try {
			facilityType.setCreatedDateTime(new Date());
			facilityType.setUpdatedDateTime(new Date());
			facilityTypeRepository.save(facilityType);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createFacilityType() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createFacilityType() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<FacilityType> getFacilityTypeList() {
		logger.info("getFacilityTypeList() started.");			
		List<FacilityType> facilityTypeList = facilityTypeRepository.findAll();
		logger.info("getFacilityTypeList() ended with facilityTypeList size - " + facilityTypeList.size());
		return facilityTypeList;
	}

	public WebServiceResult deleteFacilityType(long id) {
		logger.info("deleteFacilityType() started with facilityType Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		FacilityType facilityType = facilityTypeRepository.findById(id).orElse(null);
		if (facilityType != null) {
			try {
				facilityType.setExpiryDate(new Date());
				facilityType.setUpdatedDateTime(new Date());
				facilityTypeRepository.save(facilityType);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteFacilityType() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteFacilityType() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteFacilityType() ended, no facilityType associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updateFacilityType(@ModelAttribute FacilityType facilityType) {
		logger.info("updateFacilityType() started: " + facilityType);
		FacilityType oldFacilityType = facilityTypeRepository.findById(facilityType.getId()).orElse(null);
		WebServiceResult wsr = new WebServiceResult();
		try {
			if (facilityType != null && oldFacilityType != null) {
				facilityType.setCreatedDateTime(oldFacilityType.getCreatedDateTime());
				facilityType.setUpdatedDateTime(new Date());
				facilityTypeRepository.save(facilityType);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateFacilityType() ended successfully.");
			} else {
				wsr.setMsg("facilityType cannot be found");
				wsr.setStatus(false);
				logger.info("updateFacilityType() ended and facilityType cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateFacilityType() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
	
	public List<FacilityType> getFacilityTypeBySearch(FacilityType facilityType) {
		logger.info("getFacilityTypeBySearch() started.");		
		List<FacilityType> facilityTypeList = facilityTypeRepository.findAllByNameContaining(facilityType.getName());
		logger.info("getFacilityTypeBySearch() ended with facilityTypeList size - " + facilityTypeList.size());
		return facilityTypeList;
	}
}
