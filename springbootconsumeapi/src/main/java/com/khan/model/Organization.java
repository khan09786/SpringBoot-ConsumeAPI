package com.khan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Organization {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	private String name;

}
