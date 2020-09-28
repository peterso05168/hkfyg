package com.hkfyg.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="room_type")
public class RoomType {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "itemSeq", nullable = false)
	private Integer itemSeq = 100;
	
	@Column(name = "capacity", nullable = false)
	private Integer capacity;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "breakfast")
	private Boolean breakfast;
	
	@Column(name = "lunch")
	private Boolean lunch;
	
	@Column(name = "tea")
	private Boolean tea;
	
	@Column(name = "dinner")
	private Boolean dinner;
	
	@Column(name = "dessert")
	private Boolean dessert;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "nonProfitOrgBusyPrice")
	private BigDecimal nonProfitOrgBusyPrice;
	
	@Column(name = "nonProfitOrgNonBusyPrice")
	private BigDecimal nonProfitOrgNonBusyPrice;
	
	@Column(name = "privateOrgBusyPrice")
	private BigDecimal privateOrgBusyPrice;
	
	@Column(name = "privateOrgNonBusyPrice")
	private BigDecimal privateOrgNonBusyPrice;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "roomFlag")
	private String roomFlag;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "active")
	private String active;
	
	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;
	
	@JsonIgnore
	@OneToMany(
        mappedBy = "roomType",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
	private List<Room> rooms;
}
