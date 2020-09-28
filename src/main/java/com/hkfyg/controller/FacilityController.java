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

import com.hkfyg.model.dto.CreateFacilityDTO;
import com.hkfyg.model.entity.Facility;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.FacilityService;

@CrossOrigin("*")
@RestController
@RequestMapping("facility")
public class FacilityController {
	@Autowired
	FacilityService facilityService;
	 
	Logger logger = LoggerFactory.getLogger(FacilityController.class);
	
	@PostMapping("/createFacility")
	public WebServiceResult createFacility(@RequestBody CreateFacilityDTO createFacilityDTO) {
		return facilityService.createFacility(createFacilityDTO);	
	}
	
	@GetMapping("/getFacilityList")
	public List<Facility> getFacilityList() {	
		return facilityService.getFacilityList();
	}

	@PostMapping("/updateFacility")
	public WebServiceResult updateUserRole(@RequestBody Facility facility) {
		return facilityService.updateFacility(facility);	
	}
	
	@PostMapping("/getFacilityBySearch")
	public List<Facility> getFacilityBySearch(@RequestBody CreateFacilityDTO createFacilityDTO) {	
		return facilityService.getFacilityBySearch(createFacilityDTO);
	}
	
	//Currently does not allow delete
	@PostMapping("/deleteFacility")
	public WebServiceResult deleteFacility(long id) {		
		return null;
		//return facilityService.deleteFacility(id);
	}
}
