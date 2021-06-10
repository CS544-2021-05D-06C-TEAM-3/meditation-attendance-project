package edu.miu.attendance.controller;


import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.FacultyService;
import edu.miu.attendance.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
