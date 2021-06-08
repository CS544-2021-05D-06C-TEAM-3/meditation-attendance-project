package edu.miu.attendance.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",nullable = false, length = 255)
    private String firstName;
    @Column(name = "last_name",nullable = false, length = 255)
    private String lastName;
    private String email;
    private String username;//student ID
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToStringExclude
    private Set<Role> roleList = new HashSet<>();

    public Person(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
