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
import com.hkfyg.model.entity.FacilityType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.FacilityTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("facilityType")
public class FacilityTypeController {
	@Autowired
	FacilityTypeService facilityTypeService;
	 
	Logger logger = LoggerFactory.getLogger(FacilityTypeController.class);
	
	@PostMapping("/createFacilityType")
	public WebServiceResult createFacilityType(@RequestBody FacilityType facilityType) {
		return facilityTypeService.createFacilityType(facilityType);	
	}
	
	@GetMapping("/getFacilityTypeList")
	public List<FacilityType> getFacilityTypeList() {	
		return facilityTypeService.getFacilityTypeList();
	}

	@PostMapping("/updateFacilityType")
	public WebServiceResult updateUserRole(@RequestBody FacilityType facilityType) {
		return facilityTypeService.updateFacilityType(facilityType);	
	}
	
	@PostMapping("/getFacilityTypeBySearch")
	public List<FacilityType> getFacilityTypeBySearch(@RequestBody FacilityType facilityType) {	
		return facilityTypeService.getFacilityTypeBySearch(facilityType);
	}
	
	//Currently does not allow delete
	@PostMapping("/deleteFacilityType")
	public WebServiceResult deleteFacilityType(long id) {		
		return null;
		//return facilityTypeService.deleteFacilityType(id);
	}
}
