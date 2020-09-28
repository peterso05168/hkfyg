package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hkfyg.model.entity.RoomType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.RoomTypeRepository;

@Service
@Transactional
public class RoomTypeService {

	@Autowired
	RoomTypeRepository roomTypeRepository;

	Logger logger = LoggerFactory.getLogger(RoomTypeService.class);

	public WebServiceResult createRoomType(@ModelAttribute RoomType roomType) {
		logger.info("createRoomType() started: " + roomType);
		WebServiceResult wsr = new WebServiceResult();
		try {
			roomType.setCreatedDateTime(new Date());
			roomTypeRepository.save(roomType);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createRoomType() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createRoomType() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<RoomType> getRoomTypeList() {
		logger.info("getRoomTypeList() started.");			
		List<RoomType> roomTypeList = roomTypeRepository.findAll();
		logger.info("getRoomTypeList() ended with roomTypeList size - " + roomTypeList.size());
		return roomTypeList;
	}

	public WebServiceResult deleteRoomType(long id) {
		logger.info("deleteRoomType() started with roomType Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		RoomType roomType = roomTypeRepository.findById(id).orElse(null);
		if (roomType != null) {
			try {
				roomType.setExpiryDate(new Date());
				roomTypeRepository.save(roomType);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteRoomType() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteRoomType() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteRoomType() ended, no roomType associate with id - " + id);
		}

		return wsr;
	}
}
