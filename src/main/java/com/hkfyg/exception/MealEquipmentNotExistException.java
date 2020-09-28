package com.hkfyg.exception;

public class MealEquipmentNotExistException extends Exception {

	private static final long serialVersionUID = 1108997363449671023L;
	public static final String MEAL_EQUIPMENT_NOT_EXIST_EXCEPTION = "Meal Equipment Not Exist.";
	
	public MealEquipmentNotExistException(String message) {
		 super(message);
	}
}
