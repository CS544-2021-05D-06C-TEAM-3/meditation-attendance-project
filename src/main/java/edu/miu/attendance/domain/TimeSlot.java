package edu.miu.attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="timeSlot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "begin_date",nullable = false)
    private LocalDateTime beginTime;
    @Column(name = "end_date",nullable = false)
    private LocalDateTime endTime;
    private String description;
}
