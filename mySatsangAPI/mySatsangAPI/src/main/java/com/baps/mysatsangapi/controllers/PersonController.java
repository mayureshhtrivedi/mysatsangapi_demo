package com.baps.mysatsangapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baps.mysatsangapi.entities.Person;
import com.baps.mysatsangapi.models.PersonModel;
import com.baps.mysatsangapi.services.PersonService;
import com.baps.mysatsangapi.utils.PersonCommons;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@RestController
@RequestMapping("/v1/demo")
public class PersonController {

	
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
		Metrics.addRegistry(new SimpleMeterRegistry());

	}

	@RequestMapping(method = RequestMethod.GET, value = "/Persons")
	public Page<PersonModel> getAll(Pageable pageble) {
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.GET_ALL_PERSON_REQUEST, PersonCommons.GET_ALL_PERSON)
				.increment(PersonCommons.INCREMENT_AMOUNT);
		var response = personService.listAllPerson(pageble);
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.HTTP_RESPONSE, PersonCommons.OK)
				.increment(PersonCommons.INCREMENT_AMOUNT);

		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewPerson(@RequestBody Person newPerson) {
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.CREATE_PERSON_REQUEST, PersonCommons.CREATE_PERSON)
				.increment(PersonCommons.INCREMENT_AMOUNT);
		var response = personService.addPerson(newPerson);
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.HTTP_RESPONSE, PersonCommons.CREATED)
				.increment(PersonCommons.INCREMENT_AMOUNT);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Single item

	@GetMapping("/Persons/{id}")
	public ResponseEntity<Object> getPersonID(@PathVariable Long id) {

		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.GET_PERSON_REQUEST, PersonCommons.GET_PERSON)
				.increment(PersonCommons.INCREMENT_AMOUNT);
		var response = personService.getPerson(id);
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.HTTP_RESPONSE, PersonCommons.OK)
				.increment(PersonCommons.INCREMENT_AMOUNT);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("/Persons/{id}")
	public ResponseEntity<Object> replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.UPDATE_PERSON_REQUEST, PersonCommons.UPDATE_PERSON)
				.increment(PersonCommons.INCREMENT_AMOUNT);
		var response = personService.updatePerson(newPerson, id);
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.HTTP_RESPONSE, PersonCommons.OK)
				.increment(PersonCommons.INCREMENT_AMOUNT);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/Persons/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable Long id) {

		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.REMOVE_PERSON_REQUEST, PersonCommons.REMOVE_PERSON)
				.increment(PersonCommons.INCREMENT_AMOUNT);
		personService.removePerson(id);
		Metrics.counter(PersonCommons.MYSATSANG_API, PersonCommons.HTTP_RESPONSE, PersonCommons.OK)
				.increment(PersonCommons.INCREMENT_AMOUNT);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}