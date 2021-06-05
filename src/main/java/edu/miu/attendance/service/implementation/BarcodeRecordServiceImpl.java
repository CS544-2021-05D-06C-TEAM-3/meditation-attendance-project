package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.repository.BarcodeRecordRepository;
import edu.miu.attendance.service.BarcodeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BarcodeRecordServiceImpl implements BarcodeRecordService {

    @Autowired
    BarcodeRecordRepository barcodeRecordDAO;

    @Override
    public BarcodeRecord addBarcodeRecord(BarcodeRecord barcodeRecord) {
        return barcodeRecordDAO.save(barcodeRecord);
    }
}
