package com.spingbootelk.main.service;

import com.spingbootelk.main.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    public List<Person> allPersons();
    public Person savePerson(Person person);
    public Optional<Person> getPersonById(Long id);
    public Person updatePerson(Person person);
    public void deletePersonById(Long id);
}
