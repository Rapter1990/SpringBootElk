package com.spingbootelk.main.service.impl;

import com.spingbootelk.main.model.Person;
import com.spingbootelk.main.repository.PersonRepository;
import com.spingbootelk.main.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> allPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person updatePerson(Person personForUpdate) {

        Person updatedPerson = personRepository.findById(personForUpdate.getId()).get();

        updatedPerson.setName(personForUpdate.getName());
        updatedPerson.setSurname(personForUpdate.getSurname());
        updatedPerson.setUsername(personForUpdate.getUsername());
        updatedPerson.setBirthDate(personForUpdate.getBirthDate());
        updatedPerson.setEmail(personForUpdate.getEmail());
        updatedPerson.setPassword(personForUpdate.getPassword());

        return personRepository.save(updatedPerson);
    }

    @Override
    public void deletePersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            Person deletedPerson = person.get();
            personRepository.delete(deletedPerson);
        }
    }
}
