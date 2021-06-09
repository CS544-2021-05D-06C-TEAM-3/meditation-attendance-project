package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Student;

import edu.miu.attendance.model.BarcodeRequest;
import edu.miu.attendance.repository.BarcodeRecordRepository;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class BarcodeRecordServiceImpl implements BarcodeRecordService {


    @Autowired
    BarcodeRecordRepository barcodeRecordDAO;

    @Autowired
    StudentService studentService;

    @Override
    public BarcodeRecord addBarcodeRecord(long id, BarcodeRequest barcode) {
        Student student = studentService.findStudentById(id);
        BarcodeRecord newBarcodeRecord = new BarcodeRecord();
        newBarcodeRecord.setStudent(student);
        newBarcodeRecord.setLocation(barcode.getLocation());
        newBarcodeRecord.setTimeSlot(barcode.getSlot());
        newBarcodeRecord.setDate(barcode.getDate());
        System.out.println("location" + barcode.getLocation());
        return barcodeRecordDAO.save(newBarcodeRecord);
    }


}
