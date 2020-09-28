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

import com.hkfyg.model.entity.SystemParam;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.SystemParamService;


@CrossOrigin("*")
@RestController
@RequestMapping("systemParams")
public class SystemParamController {	
	@Autowired
	SystemParamService systemParamService;
	 
	Logger logger = LoggerFactory.getLogger(SystemParamController.class);
	
	@PostMapping("/createSystemParam")
	public WebServiceResult createSystemParam(@RequestBody SystemParam systemParam) {
		return systemParamService.createSystemParam(systemParam);		
	}
	
	@GetMapping("/getSystemParamList")
	public List<SystemParam> getSystemParamList() {		
		return systemParamService.getSystemParamList();
	}
	
	@GetMapping("/getSystemParamListByCode")
	public List<SystemParam> getSystemParamList(@RequestBody SystemParam systemParam) {		
		return systemParamService.getSystemParamListByCode(systemParam.getCode());
	}
	
	@PostMapping("/deleteSystemParam")
	public WebServiceResult deleteSystemParam(@RequestBody SystemParam systemParam) {
		return systemParamService.deleteSystemParam(systemParam.getId());		
	}
}
