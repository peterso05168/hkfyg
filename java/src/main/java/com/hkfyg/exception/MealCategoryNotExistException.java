package com.hkfyg.exception;

public class MealCategoryNotExistException extends Exception {

	private static final long serialVersionUID = 1108997363449671023L;
	public static final String MEAL_CATEGORY_NOT_EXIST_EXCEPTION = "Meal Category Not Exist.";
	
	public MealCategoryNotExistException(String message) {
		 super(message);
	}
}
