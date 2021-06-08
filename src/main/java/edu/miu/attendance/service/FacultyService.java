package edu.miu.attendance.service;

import edu.miu.attendance.domain.*;

import java.util.List;


public interface FacultyService {

    Faculty getFacultyById(long id);

    List<Student> getAllStudentForFaculty(long courseOfferingId);

    List<Course> findCoursesByFaculty(long id);

    List<CourseOffering> findCourseOfferingByFaculty(long id);

    List<BarcodeRecord> getBarcodeRecordsByCourseOfferingForFaculty(long courseOfferingId, long studentId);



}
