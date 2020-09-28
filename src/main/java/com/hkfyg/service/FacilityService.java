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

import com.hkfyg.exception.FacilityTypeNotExistException;
import com.hkfyg.model.dto.CreateFacilityDTO;
import com.hkfyg.model.entity.Facility;
import com.hkfyg.model.entity.FacilityType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.FacilityRepository;
import com.hkfyg.repository.FacilityTypeRepository;

@Service
@Transactional
public class FacilityService {

	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	FacilityTypeRepository facilityTypeRepository;

	Logger logger = LoggerFactory.getLogger(FacilityService.class);

	public WebServiceResult createFacility(CreateFacilityDTO createFacilityDTO) {
		logger.info("createFacility() started: " + createFacilityDTO);
		WebServiceResult wsr = new WebServiceResult();
		try {
			Facility facility = convertDTOtoEo(createFacilityDTO);
			facility.setCreatedDateTime(new Date());
			facility.setUpdatedDateTime(new Date());
			facilityRepository.save(facility);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createFacility() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createFacility() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<Facility> getFacilityList() {
		logger.info("getFacilityList() started.");			
		List<Facility> facilityList = facilityRepository.findAll();
		logger.info("getFacilityList() ended with facilityList size - " + facilityList.size());
		return facilityList;
	}

	public WebServiceResult deleteFacility(long id) {
		logger.info("deleteFacility() started with facility Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		Facility facility = facilityRepository.findById(id).orElse(null);
		if (facility != null) {
			try {
				facility.setExpiryDate(new Date());
				facility.setUpdatedDateTime(new Date());
				facilityRepository.save(facility);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteFacility() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteFacility() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteFacility() ended, no facility associate with id - " + id);
		}

		return wsr;
	}
	
	public WebServiceResult updateFacility(@ModelAttribute Facility facility) {
		logger.info("updateFacility() started: " + facility);
		Facility oldFacility = facilityRepository.findById(facility.getId()).orElse(null);
		WebServiceResult wsr = new WebServiceResult();
		try {
			if (facility != null && oldFacility != null) {
				facility.setCreatedDateTime(oldFacility.getCreatedDateTime());
				facility.setUpdatedDateTime(new Date());
				facilityRepository.save(facility);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("updateFacility() ended successfully.");
			} else {
				wsr.setMsg("facility cannot be found");
				wsr.setStatus(false);
				logger.info("updateFacility() ended and facility cannot be found.");
			}
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("updateFacility() ended with exception - " + e.getMessage());
		}

		return wsr;
	}
	
	public List<Facility> getFacilityBySearch(CreateFacilityDTO facility) {
		logger.info("getFacilityBySearch() started.");		
		List<Facility> facilityList = facilityRepository.findAllByNameContainingAndFacilityTypeIdAndAllowActivity(facility.getName(), facility.getFacilityTypeId(), facility.isAllowActivity());
		logger.info("getFacilityBySearch() ended with facilityList size - " + facilityList.size());
		return facilityList;
	}
	
	public Facility convertDTOtoEo (CreateFacilityDTO createFacilityDTO) throws FacilityTypeNotExistException {
		if (createFacilityDTO.getFacilityTypeId() != null) {
			Optional<FacilityType> facilityType = facilityTypeRepository.findById(createFacilityDTO.getFacilityTypeId());
			if (facilityType.isPresent()) {
				Facility facility = new Facility();
				facility.setName(createFacilityDTO.getName());
				facility.setPriority(createFacilityDTO.getPriority());
				facility.setAvailable(createFacilityDTO.isAvailable());
				facility.setAllowActivity(createFacilityDTO.isAllowActivity());
				facility.setAllowActivityShare(createFacilityDTO.isAllowActivityShare());
				facility.setAllowSameActivity(createFacilityDTO.isAllowSameActivity());
				facility.setCapacity(createFacilityDTO.getCapacity());
				facility.setCapacity(createFacilityDTO.getCapacity());
				facility.setFacilityType(facilityType.get());
				return facility;
			}
		}
		
		throw new FacilityTypeNotExistException(FacilityTypeNotExistException.FACILITY_TYPE_NOT_EXIST_EXCEPTION);		
	}
}
