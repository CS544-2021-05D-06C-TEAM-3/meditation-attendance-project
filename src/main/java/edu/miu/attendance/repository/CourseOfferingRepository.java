package edu.miu.attendance.repository;

import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

    List<CourseOffering> getCourseOfferingsByCourse(Course course);

    List<CourseOffering> getCourseOfferingsByFaculty(Faculty faculty);
}
