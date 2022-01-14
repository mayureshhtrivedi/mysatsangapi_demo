package com.baps.mysatsangapi.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.baps.mysatsangapi.handlers.PersonNotFoundException;

@ControllerAdvice
public class PersonNotFoundAdvice {
	@ResponseBody
	  @ExceptionHandler(PersonNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(PersonNotFoundException ex) {
	    return ex.getMessage();
	  }
}
