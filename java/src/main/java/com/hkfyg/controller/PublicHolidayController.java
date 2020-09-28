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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkfyg.model.entity.PublicHoliday;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.PublicHolidayService;

@CrossOrigin("*")
@RestController
@RequestMapping("publicHoliday")
public class PublicHolidayController {
	
	@Autowired
	PublicHolidayService publicHolidayService;
	 
	Logger logger = LoggerFactory.getLogger(PublicHolidayController.class);
	
	@PostMapping("/createPublicHoliday")
	public WebServiceResult createPublicHoliday(@RequestBody PublicHoliday publicHoliday) {
		return publicHolidayService.createPublicHoliday(publicHoliday);	
	}
	
	@GetMapping("/getPublicHoliday")
	public List<PublicHoliday> getPublicHoliday() {	
		return publicHolidayService.getPublicHolidayList();
	}
	
	@GetMapping("/getPublicHolidayBySearch")
	public List<PublicHoliday> getPublicHolidayBySearch(@RequestParam int year) {	
		return publicHolidayService.getPublicHolidayBySearch(year);
	}
	
	//Currently does not allow delete
		@PostMapping("/deletePublicHoliday")
		public WebServiceResult deletePublicHoliday(@RequestBody long id) {		
			return null;
			//return bedService.deleteBed(id);
		}
		
		@PostMapping("/updatePublicHoliday")
		public WebServiceResult updatePublicHoliday(@RequestBody PublicHoliday publicHoliday) {
			return publicHolidayService.updatePublicHoliday(publicHoliday);	
		}

}
