package com.hkfyg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFacilityDTO {
	private String name;
	
	private int priority;
	
	private boolean available;
	
	private boolean allowActivity;
	
	private boolean allowActivityShare;
	
	private boolean allowSameActivity;
	
	private Integer capacity;
	
	private Long facilityTypeId;
}