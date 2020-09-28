package com.hkfyg.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "MealCategory")
public class MealCategory {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_category_seq")
//	@SequenceGenerator(name = "meal_category_seq", sequenceName = "meal_category_seq", initialValue = 1, allocationSize = 1)
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

	@Column(name = "priority")
	private int priority;
	
	@JsonIgnore
	@OneToMany(
        mappedBy = "mealCategory",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
	private List<Meal> meal;

}
