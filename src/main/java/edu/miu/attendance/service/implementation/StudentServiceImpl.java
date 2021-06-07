package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.repository.BarcodeRecordRepository;
import edu.miu.attendance.repository.StudentRepository;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BarcodeRecordRepository barcodeRecordRepository;

    @Autowired
    BarcodeRecordService barcodeRecordService;

    @Override
    public Student getStudentById(Long Id) {
        return studentRepository.getById(Id);
    }

    @Override
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void changeStudentAttendanceStatus(Student student,String status) {
        if(student.getAttendanceStatus().equals("PRESENT") && status.equals("ABSENT")){
            BarcodeRecord barcode = barcodeRecordRepository.findFirstByStudent(student);
            barcodeRecordService.deleteBarcodeRecord(barcode);
            student.setAttendanceStatus(status);
        }else if (status.equals("PRESENT")){
            //clall addbarcode record
        }




    }


}
