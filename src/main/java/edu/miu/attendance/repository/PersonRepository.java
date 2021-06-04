package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByUsername(String userName);
}
