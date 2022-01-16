package com.baps.mysatsangapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.baps.mysatsangapi.entities.Person;
import com.baps.mysatsangapi.exceptions.PersonNotFoundException;
import com.baps.mysatsangapi.mappers.PersonMapper;
import com.baps.mysatsangapi.models.PersonModel;
import com.baps.mysatsangapi.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository repository;
	
	@Autowired
	private final PersonMapper personMapper;

	@Autowired
	PersonService(PersonRepository repository, PersonMapper mapper) {
		this.repository = repository;
		this.personMapper = mapper;
	}

	public Page<PersonModel> listAllPerson(Pageable pageble) {
		Page<Person> page = this.repository.findAll(pageble);
		return mapPage(page, pageble);
	}

	public Person addPerson(Person newPerson) {
		return this.repository.save(newPerson);
	}

	public PersonModel getPerson(Long id) {
		PersonModel personModel = personMapper.toModel(this.repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id)));
		return personModel;
	}

	public Person updatePerson(Person newPerson, Long id) {

		return this.repository.findById(id).map(Person -> {
			Person.setPersonName(newPerson.getPersonName());
			Person.setPersonCategory(newPerson.getPersonCategory());
			Person.setPersonMandir(newPerson.getPersonMandir());
			return this.repository.save(Person);
		}).orElseGet(() -> {
			newPerson.setId(id);
			return this.repository.save(newPerson);
		});
	}

	public void removePerson(Long id) {
		repository.deleteById(id);
	}
	
	private Page<PersonModel> mapPage(Page<Person> persons, Pageable pageable){
		List<PersonModel> allPersons = personMapper.toModels(persons.getContent());
		return new PageImpl<>(allPersons, pageable, persons.getTotalElements());
	}
}
