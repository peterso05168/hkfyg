package com.hkfyg.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="public_holiday")
public class PublicHoliday {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;
}
