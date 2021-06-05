package edu.miu.attendance.repository;

import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

    List<CourseOffering> getCourseOfferingsByCourse(Course course);
}
