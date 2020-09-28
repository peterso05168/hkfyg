package com.hkfyg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMealDTO {
	private String name;

	private String mealType;
	
	private Integer minQuantity;
	
	private String priority;	
	
	private Double price;
	
	private Double otcPrice;

	private boolean allowPublic;
	
	private String description;
	
	private int unit;
	
	private int quantity;
	
	private boolean extra;
	
	private Long mealCategoryId;
	
	private Long mealEquipmentId;

}