package com.hkfyg.model.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_role")
public class UserRole {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(name = "itemSeq", nullable = false)
	private Integer itemSeq = 100;
    
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
 
    @ManyToMany
    @JoinTable(
        name = "user_role_to_user_privilege", 
        joinColumns = @JoinColumn(
          name = "user_role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "id"))
    private Collection<UserPrivilege> userPrivileges;   
}