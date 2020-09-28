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
@Table(name="Facility")
public class Facility {
	@Id
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
	
	@Column(name = "available")
	private boolean available;
	
	@Column(name = "allowActivity")
	private boolean allowActivity;
	
	@Column(name = "allowActivityShare")
	private boolean allowActivityShare;
	
	@Column(name = "allowSameActivity")
	private boolean allowSameActivity;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;

}
