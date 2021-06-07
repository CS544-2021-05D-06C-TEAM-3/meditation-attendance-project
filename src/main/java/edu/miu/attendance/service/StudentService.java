package edu.miu.attendance.service;

import edu.miu.attendance.domain.Student;
import org.springframework.stereotype.Service;


public interface StudentService {
    Student getStudentById(Long Id);
    Student saveOrUpdateStudent(Student student);

    void changeStudentAttendanceStatus(Student student,String status);
}
