package com.hkfyg.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRoleDTO {
	private String userRoleName;
	private List<Long> privilegesIdList;
}