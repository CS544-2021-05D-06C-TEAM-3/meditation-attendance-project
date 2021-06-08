package edu.miu.attendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String code;

    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @ToStringExclude
    private List<CourseOffering> courseOfferings = new ArrayList<CourseOffering>();

    public void addCourseOfferings(CourseOffering courseOffering){
        courseOffering.setCourse(this);
        courseOfferings.add(courseOffering);
    }
}
