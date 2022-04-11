package com.spingbootelk.main.repository;

import com.spingbootelk.main.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
