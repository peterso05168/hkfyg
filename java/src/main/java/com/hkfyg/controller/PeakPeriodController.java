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

import com.hkfyg.model.entity.PeakPeriod;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.PeakPeriodService;

@CrossOrigin("*")
@RestController
@RequestMapping("peakPeriod")
public class PeakPeriodController {
	
	@Autowired
	PeakPeriodService peakPeriodService;
	 
	Logger logger = LoggerFactory.getLogger(PeakPeriodController.class);
	
	@PostMapping("/createPeakPeriod")
	public WebServiceResult createPeakPeriod(@RequestBody PeakPeriod peakPeriod) {
		return peakPeriodService.createPeakPeriod(peakPeriod);	
	}
	
	@GetMapping("/getPeakPeriod")
	public List<PeakPeriod> getPeakPeriod() {	
		return peakPeriodService.getPeakPeriodList();
	}
	
	@GetMapping("/getPeakPeriodBySearch")
	public List<PeakPeriod> getPeakPeriodBySearch(@RequestBody PeakPeriod peakPeriod) {	
		return peakPeriodService.getPeakPeriodBySearch(peakPeriod);
	}
	
	//Currently does not allow delete
		@PostMapping("/deletePeakPeriod")
		public WebServiceResult deletePublicHoliday(@RequestBody long id) {		
			return null;
			//return bedService.deleteBed(id);
		}
		
		@PostMapping("/updatePeakPeriod")
		public WebServiceResult updatePeriodService(@RequestBody PeakPeriod peakPeriod) {
			return peakPeriodService.updatePeakPeriod(peakPeriod);	
		}

}
