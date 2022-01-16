package com.baps.mysatsangapi.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.baps.mysatsangapi.exceptions.PersonNotFoundException;

import org.springframework.http.HttpStatus;



@ControllerAdvice
public class PersonNotFoundAdvice {
	@ResponseBody
	  @ExceptionHandler(PersonNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(PersonNotFoundException ex) {
	    return ex.getMessage();
	  }
}
