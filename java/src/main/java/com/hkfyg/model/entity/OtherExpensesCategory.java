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
@Table(name="other_expenses_category")
public class OtherExpensesCategory {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;

}
