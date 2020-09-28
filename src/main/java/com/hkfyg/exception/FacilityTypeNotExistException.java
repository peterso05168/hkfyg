package com.hkfyg.exception;

public class FacilityTypeNotExistException extends Exception {

	private static final long serialVersionUID = 1108997363449671023L;
	public static final String FACILITY_TYPE_NOT_EXIST_EXCEPTION = "Facility Type Not Exist.";
	
	public FacilityTypeNotExistException(String message) {
		 super(message);
	}
}
