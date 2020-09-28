package com.hkfyg.model.dto;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable{
	private final String jwttoken;
	
	private String email;
	
	private List<String> role;


	public JwtResponse(String jwttoken, String email, List<String> roles) {
		this.jwttoken = jwttoken;
		this.email = email;
		this.role = roles;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public String getEmail() {
		return email;
	}

	public List<String> getRole() {
		return role;
	}

}
