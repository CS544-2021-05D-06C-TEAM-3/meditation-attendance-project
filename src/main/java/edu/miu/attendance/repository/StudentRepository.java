package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}
