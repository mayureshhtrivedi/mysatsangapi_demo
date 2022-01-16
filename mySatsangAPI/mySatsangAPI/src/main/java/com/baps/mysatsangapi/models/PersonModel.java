package com.baps.mysatsangapi.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonModel {
	private Long id;
	private String personName;
	private String personCategory;
	private String personMandir;
	
	@Override
	public String toString() {
		return "PersonModel [id=" + id + ", personName=" + personName + ", personCategory=" + personCategory
				+ ", personMandir=" + personMandir + "]";
	}
	
	
}
