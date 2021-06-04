package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

}
