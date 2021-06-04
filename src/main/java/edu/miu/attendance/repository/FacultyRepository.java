package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, String> {

}
