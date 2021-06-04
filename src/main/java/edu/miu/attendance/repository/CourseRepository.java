package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.attendance.domain.Course;


public interface CourseRepository extends CrudRepository<Course,String>{
	
}
