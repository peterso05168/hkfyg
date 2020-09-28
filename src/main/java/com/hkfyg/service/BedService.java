package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkfyg.exception.RoomNotExistException;
import com.hkfyg.model.dto.CreateBedDTO;
import com.hkfyg.model.entity.Bed;
import com.hkfyg.model.entity.Room;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.BedRepository;
import com.hkfyg.repository.RoomRepository;

@Service
@Transactional
public class BedService {

	@Autowired
	BedRepository bedRepository;
	
	@Autowired
	RoomRepository roomRepository;

	Logger logger = LoggerFactory.getLogger(BedService.class);

	public WebServiceResult createBed(CreateBedDTO createBedDTO) {
		logger.info("createBed() started: " + createBedDTO);
		WebServiceResult wsr = new WebServiceResult();
		try {
			Bed bed = convertDTOtoEo(createBedDTO);
			bed.setCreatedDateTime(new Date());
			bedRepository.save(bed);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createBed() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createBed() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<Bed> getBedList() {
		logger.info("getBedList() started.");			
		List<Bed> bedList = bedRepository.findAll();
		logger.info("getBedList() ended with BedList size - " + bedList.size());
		return bedList;
	}

	public WebServiceResult deleteBed(long id) {
		logger.info("deleteBed() started with Bed Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		Bed bed = bedRepository.findById(id).orElse(null);
		if (bed != null) {
			try {
				bed.setExpiryDate(new Date());
				bedRepository.save(bed);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteBed() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteBed() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteBed() ended, no Bed associate with id - " + id);
		}

		return wsr;
	}
	
	public Bed convertDTOtoEo (CreateBedDTO createBedDTO) throws RoomNotExistException {
		if (createBedDTO.getRoomId() != null) {
			Optional<Room> room = roomRepository.findById(createBedDTO.getRoomId());
			if (room.isPresent()) {
				Bed Bed = new Bed();
				Bed.setItemSeq(createBedDTO.getItemSeq());
				Bed.setBedNo(createBedDTO.getBedNo());
				Bed.setBedStatus(createBedDTO.getBedStatus());
				Bed.setRoom(room.get());
				return Bed;
			}
		}		
		
		throw new RoomNotExistException(RoomNotExistException.ROOM_NOT_EXIST_EXCEPTION);		
	}
}
