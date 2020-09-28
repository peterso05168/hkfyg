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

import com.hkfyg.model.entity.OrgType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.OrgTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("orgType")
public class OrgTypeController {
	@Autowired
	OrgTypeService orgTypeService;
	 
	Logger logger = LoggerFactory.getLogger(OrgTypeController.class);
	
	@PostMapping("/createOrgType")
	public WebServiceResult createOrgType(@RequestBody OrgType orgType) {
		return null;	
	}
	
	@GetMapping("/getOrgTypeList")
	public List<OrgType> getOrgTypeList() {	
		return null;
	}

	//Currently does not allow delete
	@PostMapping("/deleteOrgType")
	public WebServiceResult deleteOrgType(long id) {		
		return null;
	}
}
