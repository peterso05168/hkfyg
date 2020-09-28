package com.hkfyg.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebServiceResult {
	public static final String SUCCESS = "success";
	public static final String FAILED = "failed";
	
	private boolean status;
	private String msg;
	private Exception e;
}
