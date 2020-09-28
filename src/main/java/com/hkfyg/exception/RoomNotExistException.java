package com.hkfyg.exception;

public class RoomNotExistException extends Exception {

	private static final long serialVersionUID = 1108997363449671023L;
	public static final String ROOM_NOT_EXIST_EXCEPTION = "Room Not Exist.";
	
	public RoomNotExistException(String message) {
		 super(message);
	}
}
