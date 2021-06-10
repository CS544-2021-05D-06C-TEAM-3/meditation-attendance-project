package edu.miu.attendance.service;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.model.StudentRequest;

import java.util.List;

public interface StudentService {
    Student findByUsername(String username);

    Student registerStudent(StudentRequest student);

    List<Student> getAllStudent();

    Student findStudentById(long id);

    void deleteStudentById(long id);

    List<Course> getAllCoursesByStudent();

    List<CourseOffering> getAllCourseOfferingsForStudent(long id);

    List<BarcodeRecord> getAllBarcodeRecordForStudentByCourseOffering(long courseOfferingId);

    List<BarcodeRecord> getAllBarcodeRecordForStudent();

}
