package com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RoleBi {

	@Id
	@GeneratedValue
	private Integer roleId;
	private String roleName;

	@OneToOne(mappedBy = "role")
	private UserBi user;
}