package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.CourseSession;

public interface CourseSessionRepository extends JpaRepository<CourseSession, String> {

}
