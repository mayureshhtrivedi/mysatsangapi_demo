package com.baps.mysatsangapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.baps.mysatsangapi.advices.PersonNotFoundAdvice;
import com.baps.mysatsangapi.configurations.DatabaseConfig;
import com.baps.mysatsangapi.controllers.PersonController;
import com.baps.mysatsangapi.entities.Person;
import com.baps.mysatsangapi.exceptions.PersonNotFoundException;
import com.baps.mysatsangapi.filters.MetricsFilter;
import com.baps.mysatsangapi.mappers.PersonMapper;
import com.baps.mysatsangapi.models.PersonModel;
import com.baps.mysatsangapi.repositories.PersonRepository;
import com.baps.mysatsangapi.services.PersonService;
import com.baps.mysatsangapi.utils.PersonCommons;


@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(
//basePackageClasses = {PersonMapper.class,PersonNotFoundAdvice.class,DatabaseConfig.class,PersonController.class,Person.class,PersonNotFoundException.class,
//		MetricsFilter.class,PersonModel.class,PersonRepository.class,PersonService.class,PersonCommons.class})
public class MySatsangApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySatsangApiApplication.class, args);
	}

}
