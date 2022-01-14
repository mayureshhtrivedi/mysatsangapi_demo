package com.baps.mysatsangapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Person implements Serializable{

	private static final long serialVersionUID = -1188536722375232294L;
	private @Id @GeneratedValue Long id;
	private String personName;
	private String personCategory;
	private String personMandir;
	
	public Person() {}

	public Person(String name, String category, String temple) {

	    this.personName = name;
	    this.personCategory = category;
	    this.personMandir = temple;
	  }

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonCategory() {
		return personCategory;
	}

	public void setPersonCategory(String personCategory) {
		this.personCategory = personCategory;
	}

	public String getPersonMandir() {
		return personMandir;
	}

	public void setPersonMandir(String personMandir) {
		this.personMandir = personMandir;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
