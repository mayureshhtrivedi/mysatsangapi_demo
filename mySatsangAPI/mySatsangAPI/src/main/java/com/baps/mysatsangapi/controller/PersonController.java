package com.baps.mysatsangapi.controller;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baps.mysatsangapi.models.Person;
import com.baps.mysatsangapi.repository.PersonRepository;
import com.baps.mysatsangapi.handlers.PersonNotFoundException;

@RestController
@RequestMapping("/v1/demo")
public class PersonController {

  private final PersonRepository repository;

  PersonController(PersonRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/Persons")
  List<Person> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/Persons")
  Person newPerson(@RequestBody Person newPerson) {
    return repository.save(newPerson);
  }

  // Single item
  
  @GetMapping("/Persons/{id}")
  Person one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new PersonNotFoundException(id));
  }

  @PutMapping("/Persons/{id}")
  Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Person -> {
        Person.setPersonName(newPerson.getPersonName());
        Person.setPersonCategory(newPerson.getPersonCategory());
        Person.setPersonMandir(newPerson.getPersonMandir());
        return repository.save(Person);
      })
      .orElseGet(() -> {
        newPerson.setId(id);
        return repository.save(newPerson);
      });
  }

  @DeleteMapping("/Persons/{id}")
  void deletePerson(@PathVariable Long id) {
    repository.deleteById(id);
  }
}