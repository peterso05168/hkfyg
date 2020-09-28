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

import com.hkfyg.model.entity.RoomType;
import com.hkfyg.model.entity.WebServiceResult;
import com.hkfyg.service.RoomTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("roomType")
public class RoomTypeController {
	@Autowired
	RoomTypeService roomTypeService;
	 
	Logger logger = LoggerFactory.getLogger(RoomTypeController.class);
	
	@PostMapping("/createRoomType")
	public WebServiceResult createRoomType(@RequestBody RoomType roomType) {
		return roomTypeService.createRoomType(roomType);	
	}
	
	@GetMapping("/getRoomTypeList")
	public List<RoomType> getRoomTypeList() {	
		return roomTypeService.getRoomTypeList();
	}

	//Currently does not allow delete
	@PostMapping("/deleteRoomType")
	public WebServiceResult deleteRoomType(long id) {		
		return null;
		//return roomTypeService.deleteRoomType(id);
	}
}
