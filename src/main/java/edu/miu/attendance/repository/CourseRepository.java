package edu.miu.attendance.repository;

import edu.miu.attendance.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {


}
