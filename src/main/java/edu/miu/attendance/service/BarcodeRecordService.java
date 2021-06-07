package edu.miu.attendance.service;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Student;

public interface BarcodeRecordService {

    BarcodeRecord addBarcodeRecord(BarcodeRecord barcodeRecord);
    void deleteBarcodeRecord(BarcodeRecord barcodeRecord);
}
