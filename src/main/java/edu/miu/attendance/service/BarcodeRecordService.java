package edu.miu.attendance.service;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.model.BarcodeRequest;

import java.util.List;

public interface BarcodeRecordService {

    BarcodeRecord addBarcodeRecord(BarcodeRequest barcodeRecord);

    List<BarcodeRecord> findAllByStudent(Student student);

}
