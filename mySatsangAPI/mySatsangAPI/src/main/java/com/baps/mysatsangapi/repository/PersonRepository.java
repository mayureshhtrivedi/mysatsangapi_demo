package com.baps.mysatsangapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.baps.mysatsangapi.models.Person;
public interface PersonRepository extends JpaRepository<Person, Long> {

}