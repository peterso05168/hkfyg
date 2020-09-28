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

import com.hkfyg.model.dto.CreateRoomDTO;
import com.hkfyg.model.entity.Room;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.RoomService;

@CrossOrigin("*")
@RestController
@RequestMapping("room")
public class RoomController {
	@Autowired
	RoomService roomService;
	 
	Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@PostMapping("/createRoom")
	public WebServiceResult createRoom(@RequestBody CreateRoomDTO createRoomDTO) {
		return roomService.createRoom(createRoomDTO);	
	}
	
	@GetMapping("/getRoomList")
	public List<Room> getRoomList() {	
		return roomService.getRoomList();
	}

	//Currently does not allow delete
	@PostMapping("/deleteRoom")
	public WebServiceResult deleteRoom(long id) {		
		return null;
		//return roomService.deleteRoom(id);
	}
}
