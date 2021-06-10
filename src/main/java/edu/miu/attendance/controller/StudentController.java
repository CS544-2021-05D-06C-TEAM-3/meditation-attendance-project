package edu.miu.attendance.controller;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.dto.CourseDto;
import edu.miu.attendance.model.BarcodeRequest;
import edu.miu.attendance.model.StudentRequest;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    BarcodeRecordService barcodeRecordService;


    @GetMapping("students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("student/register")
    public Student registerStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.registerStudent(studentRequest);
    }

    @GetMapping("student/courses")
    public List<CourseDto> getCoursesForStudent() {
        return studentService.getAllCoursesByStudent();
    }

    @PostMapping("student/checkinBarcode")
    public BarcodeRecord addBarcodeRecord(@RequestBody BarcodeRequest barcodeRequest) {
        return barcodeRecordService.addBarcodeRecord(barcodeRequest);
    }

    @GetMapping("student/barcodeRecords")
    public List<BarcodeRecord> getAllBarcodeRecordsOfStudent(){
        return studentService.getAllBarcodeRecordForStudent();

    }
    @GetMapping("student/courseOfferings/{courseOfferingId}/barcodeRecords")
    public List<BarcodeRecord> getAttendanceForStudent(@PathVariable long courseOfferingId) {
        return studentService.getAllBarcodeRecordForStudentByCourseOffering(courseOfferingId);

    }
}
