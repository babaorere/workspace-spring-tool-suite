package com.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

	@ManyToMany
	private List<Role> roles;
}