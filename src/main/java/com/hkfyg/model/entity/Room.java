package com.hkfyg.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "itemSeq", nullable = false)
	private Integer itemSeq = 100;
	
	@Column(name = "roomNo", nullable = false)
	private String roomNo;
	
	@Column(name = "roomStatus", nullable = false)
	private String roomStatus;
	
	@Column(name = "reserved")
	private Boolean reserved = false;
	
	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;

	@JsonIgnore
	@OneToMany(
        mappedBy = "room",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
	private List<Bed> beds;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private RoomType roomType;
}
