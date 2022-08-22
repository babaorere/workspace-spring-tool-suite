package com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data; // no se puede utilizar, porque genera una relacion recursiva con tostring, equals, hash
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class RoleBi {

	@Id
	@GeneratedValue
	private Integer roleId;
	private String roleName;

	// The owning side initiates the creation of the relationship to the database.
	// Generally, this is the side where the foreign key resides.
	@ManyToOne
	private User user;
}