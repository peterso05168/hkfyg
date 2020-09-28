package com.hkfyg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBedDTO {
	private Integer itemSeq;

	private String bedNo;

	private Long roomId;

	private String bedStatus;
}