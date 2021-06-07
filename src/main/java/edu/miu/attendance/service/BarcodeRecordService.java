package edu.miu.attendance.service;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.model.BarcodeRequest;

public interface BarcodeRecordService {

    BarcodeRecord addBarcodeRecord(long id, BarcodeRequest barcodeRecord);

}
