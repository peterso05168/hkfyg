package com.hkfyg.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hkfyg.model.entity.SystemParam;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.SystemParamRepository;

@Service
@Transactional
public class SystemParamService {

	@Autowired
	SystemParamRepository systemParamRepository;

	Logger logger = LoggerFactory.getLogger(SystemParamService.class);

	public WebServiceResult createSystemParam(SystemParam systemParam) {
		WebServiceResult wsr = new WebServiceResult();
		logger.info("createSystemParam() started");
		try {
			systemParam.setCreatedDateTime(new Date());
			systemParamRepository.save(systemParam);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createSystemParam() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createSystemParam() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<SystemParam> getSystemParamList() {
		logger.info("getSystemParamList() started.");
		List<SystemParam> systemParamList = systemParamRepository.findAll(Sort.by("createdDateTime").descending());
		logger.info("getSystemParamList() ended with PartnersList size - " + systemParamList.size());
		return systemParamList;
	}
	
	public List<SystemParam> getSystemParamListByCode(String code) {
		logger.info("getSystemParamListByCode() started.");
		List<SystemParam> systemParamList = systemParamRepository.findByCode(code);
		logger.info("getSystemParamListByCode() ended with PartnersList size - " + systemParamList.size());
		return systemParamList;
	}

	public WebServiceResult deleteSystemParam(long id) {
		logger.info("deleteSystemParam() started with systemParam Id - " + id);
		WebServiceResult wsr = new WebServiceResult();

		SystemParam systemParam = systemParamRepository.findById(id).orElse(null);
		if (systemParam != null) {
			try {
				systemParam.setExpiryDate(new Date());
				systemParamRepository.save(systemParam);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteSystemParam() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteSystemParam() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteSystemParam() ended, no systemParam associate with id - " + id);
		}

		return wsr;
	}
}
