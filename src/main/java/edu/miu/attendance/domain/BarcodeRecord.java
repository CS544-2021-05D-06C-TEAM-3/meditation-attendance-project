package edu.miu.attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="barcode")
public class BarcodeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String attendanceStatus;
    @ManyToOne
    private Student student;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Location location;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private TimeSlot timeSlot;
}
