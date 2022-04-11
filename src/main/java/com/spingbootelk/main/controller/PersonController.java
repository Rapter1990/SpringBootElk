package com.spingbootelk.main.controller;

import com.spingbootelk.main.error.ResourceNotFoundException;
import com.spingbootelk.main.model.Person;
import com.spingbootelk.main.service.impl.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons(){
        LOGGER.info("PersonController | getPersons is started");
        return personService.allPersons();
    }

    @PostMapping("/persons/save")
    public Person addPerson(@RequestBody Person person){
        LOGGER.info("PersonController | addPerson is started");
        personService.savePerson(person);
        LOGGER.info("PersonController | addPerson | Person is saved");
        return person;
    }

    @GetMapping("/persons/{id}")
    public Person findPersonById(@PathVariable("id") Long personId){
        LOGGER.info("PersonController | findPersonById is started");
        Person person = personService.getPersonById(personId).orElseThrow(
                () -> new ResourceNotFoundException("Person not found... by Id : " +personId));
        LOGGER.info("PersonController | findPersonById | Person is found");
        return person;
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable(value="id") Long personId, @RequestBody Person personBody){
        LOGGER.info("PersonController | updatePerson is started");
        Person updatedPerson = personService.updatePerson(personId,personBody);
        LOGGER.info("PersonController | updatePerson | Updated Person Info : " + updatedPerson.toString());
        return updatedPerson;
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable(value="id") Long personId) {
        LOGGER.info("PersonController | deletePerson is started");
        personService.deletePersonById(personId);
        LOGGER.info("PersonController | deletePerson | Person " + personId + " is deleted");
    }
}
