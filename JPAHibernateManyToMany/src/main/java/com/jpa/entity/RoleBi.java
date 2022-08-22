package com.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}