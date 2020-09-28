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
@Table(name = "MealEquipment")
public class MealEquipment {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_equipment_seq")
//	@SequenceGenerator(name = "meal_equipment_seq", sequenceName = "meal_equipment_seq", initialValue = 1, allocationSize = 1)
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

	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "bookLimit")
	private boolean bookingLimit;
		
	@Column(name = "bCampFrom")
	private Date bCampFrom;
	
	@Column(name = "bCampTo")
	private Date bCampTo;
	
	@Column(name = "bNotCampFrom")
	private Date bNotCampFrom;
	
	@Column(name = "bNotCampTo")
	private Date bNotCampTo;

	@Column(name = "bBoth")
	private Boolean bBoth;
	
	@Column(name = "lCampFrom")
	private Date lCampFrom;
	
	@Column(name = "lCampTo")
	private Date lCampTo;
	
	@Column(name = "lNotCampFrom")
	private Date lNotCampFrom;
	
	@Column(name = "lNotCampTo")
	private Date lNotCampTo;
	
	@Column(name = "lBoth")
	private Boolean lBoth;
	
	@Column(name = "tCampFrom")
	private Date tCampFrom;
	
	@Column(name = "tCampTo")
	private Date tCampTo;
	
	@Column(name = "tNotCampFrom")
	private Date tNotCampFrom;
	
	@Column(name = "tNotCampTo")
	private Date tNotCampTo;
	
	@Column(name = "tBoth")
	private Boolean tBoth;
	
	@Column(name = "dCampFrom")
	private Date dCampFrom;
	
	@Column(name = "dCampTo")
	private Date dCampTo;
	
	@Column(name = "dNotCampFrom")
	private Date dNotCampFrom;
	
	@Column(name = "dNotCampTo")
	private Date dNotCampTo;
	
	@Column(name = "dBoth")
	private Boolean dBoth;
	
	@Column(name = "sCampFrom")
	private Date sCampFrom;
	
	@Column(name = "sCampTo")
	private Date sCampTo;
	
	@Column(name = "sNotCampFrom")
	private Date sNotCampFrom;
	
	@Column(name = "sNotCampTo")
	private Date sNotCampTo;
	
	@Column(name = "sBoth")
	private Boolean sBoth;
	
	@JsonIgnore
	@OneToMany(
        mappedBy = "mealEquipment",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
	private List<Meal> meal;

}
