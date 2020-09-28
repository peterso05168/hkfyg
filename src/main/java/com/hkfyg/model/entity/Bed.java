package com.hkfyg.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bed")
public class Bed {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "itemSeq", nullable = false)
	private Integer itemSeq = 100;
	
	@Column(name = "bedNo", nullable = false)
	private String bedNo;
	
	@Column(name = "bedStatus", nullable = false)
	private String bedStatus;
	
	@Column(name = "reserved")
	private Boolean reserved;
	
	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
}
