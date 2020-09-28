package com.hkfyg.model.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Meal")
public class Meal {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="meal_seq")
//	@SequenceGenerator(name = "meal_seq", sequenceName = "meal_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "createdDateTime")
	private Date createdDateTime;
	
	@Column(name = "updatedDateTime")
	private Date updatedDateTime;
	
	@Column(name = "expiry_date", nullable = true)
	private Date expiryDate;
	
	@Column(name = "name")
	private String name;

	@Column(name = "mealType")
	private String mealType;
	
	@Column(name = "minQuantity")
	private Integer minQuantity;
	
	@Column(name = "priority")
	private String priority;	
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "otcPrice")
	private Double otcPrice;

	@Column(name = "allowPublic")
	private boolean allowPublic;
	
	@Column(name = "description")
	private String description;
	
	//1 for per people, 2 for per table
	@Column(name = "unit")
	private int unit;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "extra")
	private boolean extra;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_category_id", referencedColumnName = "id")
    private MealCategory mealCategory;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_equipment_id", referencedColumnName = "id")
    private MealEquipment mealEquipment;

}
