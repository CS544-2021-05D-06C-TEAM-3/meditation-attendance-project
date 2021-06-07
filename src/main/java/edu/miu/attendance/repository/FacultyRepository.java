package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByUsername(String username);
}
