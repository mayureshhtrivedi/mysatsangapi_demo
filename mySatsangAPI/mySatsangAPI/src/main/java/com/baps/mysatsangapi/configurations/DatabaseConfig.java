package com.baps.mysatsangapi.configurations;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baps.mysatsangapi.entities.Person;
import com.baps.mysatsangapi.repositories.PersonRepository;


@Configuration
public class DatabaseConfig {

  private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

  @Bean
  CommandLineRunner initDatabase(PersonRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Person("Mayuresh", "Satsangi", "Richmond")));
      log.info("Preloading " + repository.save(new Person("Satyanishtha Swami", "Sant", "Robinsville")));
    };
  }
}