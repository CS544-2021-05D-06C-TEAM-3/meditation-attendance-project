package edu.miu.attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="courseOffering")
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate start_date;
    private LocalDate end_date;
    private int capacity;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Course course;

    @OneToMany
    private List<CourseSession> courseSessions = new ArrayList<CourseSession>();

    @OneToMany
    private List<Registration> registrations = new ArrayList<Registration>();
}
