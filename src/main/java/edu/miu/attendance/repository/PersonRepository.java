package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
