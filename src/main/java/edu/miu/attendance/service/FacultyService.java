package edu.miu.attendance.service;

import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.Faculty;
import edu.miu.attendance.domain.Student;

import java.util.List;


public interface FacultyService {

    Faculty getFacultyByUsername(String username) ;
    Faculty getFacultyById(long id);

    List<Student> getAllStudentForFaculty(long id);

    List<Course> findCoursesByFaculty(long id);

    List<CourseOffering> findCourseOfferingByFaculty(long id);

//    void changeStudentAttendanceStatus(long id, String status);

}
