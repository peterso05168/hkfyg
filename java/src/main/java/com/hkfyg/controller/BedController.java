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

import com.hkfyg.model.dto.CreateBedDTO;
import com.hkfyg.model.entity.Bed;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.BedService;

@CrossOrigin("*")
@RestController
@RequestMapping("bed")
public class BedController {
	@Autowired
	BedService bedService;
	 
	Logger logger = LoggerFactory.getLogger(BedController.class);
	
	@PostMapping("/createBed")
	public WebServiceResult createBed(@RequestBody CreateBedDTO createBedDTO) {
		return bedService.createBed(createBedDTO);	
	}
	
	@GetMapping("/getBedList")
	public List<Bed> getBedList() {	
		return bedService.getBedList();
	}

	//Currently does not allow delete
	@PostMapping("/deleteBed")
	public WebServiceResult deleteBed(long id) {		
		return null;
		//return bedService.deleteBed(id);
	}
}
