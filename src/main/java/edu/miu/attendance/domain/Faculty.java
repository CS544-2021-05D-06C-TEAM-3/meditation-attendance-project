package edu.miu.attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Faculty extends Person {
    private String position;
    @OneToMany
    private List<CourseOffering> courseOfferingList = new ArrayList<CourseOffering>();
}
