package edu.miu.attendance.service;

import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.model.StudentRequest;

import java.util.List;

public interface StudentService {

    Student registerStudent(StudentRequest student);

    Student findStudentById(long id);

    void deleteStudentById(long id);

    List<Course> getAllCoursesByStudent(long id);
}
