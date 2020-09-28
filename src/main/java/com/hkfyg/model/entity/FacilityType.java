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
@Table(name = "FacilityType")
public class FacilityType {
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

	@Column(name = "ngoPrice")
	private Double ngoPrice;

	@Column(name = "privatePrice")
	private Double privatePrice;

	@Column(name = "allowBook")
	private boolean allowBook;

	@Column(name = "allowPublicBook")
	private boolean allowPublicBook;

	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany(
        mappedBy = "facilityType",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
	private List<Facility> facility;

}
