package com.hkfyg.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="org_type")
public class OrgType {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "itemSeq", nullable = false)
	private Integer itemSeq = 100;
	
	@Column(name = "orgNature", nullable = false)
	private String orgNature;
	
	@Column(name = "orgChinNature", nullable = false)
	private String orgChinNature;
	
	@Column(name = "checkInDaysRestriction", nullable = false)
	private Integer checkInDaysRestriction = 30;
	
	@Column(name = "disclaimerBeforeApplication", nullable = false, columnDefinition = "TEXT(65536)")
	private String disclaimerBeforeApplication;
	
	@Column(name = "disclaimerSubmitApplication", nullable = false, columnDefinition = "TEXT(65536)")
	private String disclaimerSubmitApplication;
	
	@Column(name = "pymtThroughOnlineRestriction", nullable = false)
	private String pymtThroughOnlineRestriction;
	
	@Column(name = "pymtThroughBankDepositRestriction", nullable = false)
	private String pymtThroughBankDepositRestriction;
	
	@Column(name = "enablePublicBooking", nullable = false)
	private Boolean enablePublicBooking;
	
	@Column(name = "isHKFYGUnit", nullable = false)
	private Boolean isHKFYGUnit;
	
	@Column(name = "mealDaysRestriction", nullable = false)
	private Integer mealDaysRestriction = 14;
	
	@Column(name = "activityDaysRestriction", nullable = false)
	private Integer activityDaysRestriction = 30;
	
	@Column(name = "createdDateTime", nullable = false)
	private Date createdDateTime;
	
	@Column(name = "expiryDate", nullable = true)
	private Date expiryDate;
}
