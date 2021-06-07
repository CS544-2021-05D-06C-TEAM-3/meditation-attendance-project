package edu.miu.attendance.model;

import edu.miu.attendance.domain.Location;
import edu.miu.attendance.domain.TimeSlot;
import lombok.Data;

@Data

public class BarcodeRequest {

    Location location;
    TimeSlot slot;
}
