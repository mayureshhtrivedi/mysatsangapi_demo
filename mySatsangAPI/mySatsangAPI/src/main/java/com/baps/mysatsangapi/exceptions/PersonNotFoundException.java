package com.baps.mysatsangapi.exceptions;

public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4275944867151577649L;

	public PersonNotFoundException(Long id) {
	    super("Could not find person with ID: " + id);
	  }
	}
