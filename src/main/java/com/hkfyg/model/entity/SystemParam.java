package com.hkfyg.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="system_param")
public class SystemParam {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "module", nullable = false)
	private String module;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "value", nullable = false, columnDefinition = "TEXT(10000)")
	private String value;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;
}
