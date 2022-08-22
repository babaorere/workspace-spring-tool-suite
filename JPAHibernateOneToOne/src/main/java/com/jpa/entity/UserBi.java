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
public class UserBi {

	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String userPwd;

	@OneToOne
	private RoleBi role;
}