package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Course;


public interface CourseRepository extends JpaRepository<Course,Long>{
	
}
