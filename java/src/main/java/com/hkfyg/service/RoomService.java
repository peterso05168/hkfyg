package com.hkfyg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hkfyg.exception.RoomTypeNotExistException;
import com.hkfyg.model.dto.CreateRoomDTO;
import com.hkfyg.model.entity.Room;
import com.hkfyg.model.entity.RoomType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.repository.RoomRepository;
import com.hkfyg.repository.RoomTypeRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	RoomTypeRepository roomTypeRepository;

	Logger logger = LoggerFactory.getLogger(RoomService.class);

	public WebServiceResult createRoom(CreateRoomDTO createRoomDTO) {
		logger.info("createRoom() started: " + createRoomDTO);
		WebServiceResult wsr = new WebServiceResult();
		try {
			Room room = convertDTOtoEo(createRoomDTO);
			room.setCreatedDateTime(new Date());
			roomRepository.save(room);
			wsr.setMsg(WebServiceResult.SUCCESS);
			wsr.setStatus(true);
			logger.info("createRoom() ended successfully.");
		} catch (Exception e) {
			wsr.setMsg(e.getMessage());
			wsr.setStatus(false);
			wsr.setE(e);
			logger.info("createRoom() ended with exception - " + e.getMessage());
		}

		return wsr;
	}

	public List<Room> getRoomList() {
		logger.info("getRoomList() started.");			
		List<Room> roomList = roomRepository.findAll();
		logger.info("getRoomList() ended with RoomList size - " + roomList.size());
		return roomList;
	}

	public WebServiceResult deleteRoom(long id) {
		logger.info("deleteRoom() started with Room Id - " + id);
		WebServiceResult wsr = new WebServiceResult();
		Room room = roomRepository.findById(id).orElse(null);
		if (room != null) {
			try {
				room.setExpiryDate(new Date());
				roomRepository.save(room);
				wsr.setMsg(WebServiceResult.SUCCESS);
				wsr.setStatus(true);
				logger.info("deleteRoom() ended successfully.");
			} catch (Exception e) {
				wsr.setMsg(e.getMessage());
				wsr.setStatus(false);
				wsr.setE(e);
				logger.info("deleteRoom() ended with exception - " + e.getMessage());
			}
		} else {
			wsr.setMsg(WebServiceResult.FAILED);
			wsr.setStatus(false);
			logger.info("deleteRoom() ended, no Room associate with id - " + id);
		}

		return wsr;
	}
	
	public Room convertDTOtoEo (CreateRoomDTO createRoomDTO) throws RoomTypeNotExistException {
		if (createRoomDTO.getRoomTypeId() != null) {
			Optional<RoomType> roomType = roomTypeRepository.findById(createRoomDTO.getRoomTypeId());
			if (roomType.isPresent()) {
				Room room = new Room();
				room.setItemSeq(createRoomDTO.getItemSeq());
				room.setRoomNo(createRoomDTO.getRoomNo());
				room.setRoomStatus(createRoomDTO.getRoomStatus());
				room.setRoomType(roomType.get());
				return room;
			}
		}
		
		throw new RoomTypeNotExistException(RoomTypeNotExistException.ROOM_TYPE_NOT_EXIST_EXCEPTION);		
	}
}
