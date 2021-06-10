package edu.miu.attendance.controller;


import edu.miu.attendance.domain.*;
import edu.miu.attendance.model.FacultyRequest;
import edu.miu.attendance.model.StudentRequest;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.FacultyService;
import edu.miu.attendance.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    RegistrationService registrationService;


    @Autowired
    private FacultyService facultyService;



    @GetMapping("/faculty/courses")
    public List<Course> getCoursesForFaculty() {
        return facultyService.findCoursesByFaculty();
    }

    @GetMapping("faculty/{id}")
    public Faculty getStudentById(@PathVariable long id) {
        return facultyService.getFacultyById(id);
    }

    @PostMapping("faculty/register")
    public Faculty registerStudent(@RequestBody FacultyRequest facultyRequest) {
        return facultyService.registerFaculty(facultyRequest);
    }

    @GetMapping("/faculty/courseOfferings")
    public List<CourseOffering> getCourseOfferingsForFaculty() {
        return facultyService.findCourseOfferingByFaculty();
    }

    @GetMapping("/faculty/courseOffering/{id}/students")
    public List<Student> getRegisteredStudentForFaculty(@PathVariable long id) {
        return facultyService.getAllStudentForFaculty(id);
    }

    @GetMapping("/student/{studentId}/courseOffering/{courseOfferingId}/barcodeRecords")
    public List<BarcodeRecord> getAttendanceForStudent(@PathVariable long studentId, @PathVariable long courseOfferingId) {
        return facultyService.getBarcodeRecordsByCourseOfferingForFaculty(courseOfferingId, studentId);

    }

}
