package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.miu.attendance.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
