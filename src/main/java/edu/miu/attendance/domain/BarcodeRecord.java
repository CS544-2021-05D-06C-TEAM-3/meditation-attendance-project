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

    @ManyToOne
    private Student student;

    @ManyToOne
    private Location location;

    @ManyToOne
    private TimeSlot timeSlot;
}
