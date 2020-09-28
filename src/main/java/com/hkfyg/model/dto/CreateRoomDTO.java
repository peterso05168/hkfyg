package com.hkfyg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomDTO {
	private Integer itemSeq;

	private String roomNo;

	private Long roomTypeId;

	private String roomStatus;
}