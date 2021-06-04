package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
