package com.baps.mysatsangapi.handlers;

public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(Long id) {
	    super("Could not find person with ID: " + id);
	  }
	}
