package com.baps.mysatsangapi.mappers;



import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baps.mysatsangapi.entities.Person;
import com.baps.mysatsangapi.models.PersonModel;
import com.baps.mysatsangapi.services.PersonService;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonModel toModel(Person person);
	
	List<PersonModel> toModels(List<Person> persons); 
}
