package com.hkfyg.exception;

public class RoomTypeNotExistException extends Exception {

	private static final long serialVersionUID = 1108997363449671023L;
	public static final String ROOM_TYPE_NOT_EXIST_EXCEPTION = "Room Type Not Exist.";
	
	public RoomTypeNotExistException(String message) {
		 super(message);
	}
}
