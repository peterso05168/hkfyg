package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkfyg.model.entity.OrgType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.OrgTypeRepository;

@Service
@Transactional
public class OrgTypeService {

	@Autowired
	OrgTypeRepository orgTypeRepository;

	Logger logger = LoggerFactory.getLogger(OrgTypeService.class);

	public WebServiceResult createOrgType(OrgType orgType) {
		logger.info("createOrgType() started: " + orgType);
		WebServiceResult wsr = new WebServiceResult();
		try {
			orgType.setCreatedDateTime(new Date());
			orgTypeRepository.save(orgType);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createOrgType() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createOrgType() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<OrgType> getOrgTypeList() {
		logger.info("getOrgTypeList() started.");			
		List<OrgType> orgTypeList = orgTypeRepository.findAll();
		logger.info("getOrgTypeList() ended with OrgTypeList size - " + orgTypeList.size());
		return orgTypeList;
	}

	public WebServiceResult deleteOrgType(long id) {
		logger.info("deleteOrgType() started with OrgType Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		OrgType orgType = orgTypeRepository.findById(id).orElse(null);
		if (orgType != null) {
			try {
				orgType.setExpiryDate(new Date());
				orgTypeRepository.save(orgType);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteOrgType() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteOrgType() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteOrgType() ended, no OrgType associate with id - " + id);
		}

		return wsr;
	}
}
