package edu.miu.attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student extends Person{
    private String barcode;
    private LocalDate entry;
    @OneToMany
    private List<Registration> registrationList = new ArrayList<Registration>();
}
