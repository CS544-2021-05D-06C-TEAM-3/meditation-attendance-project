package edu.miu.attendance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;//student ID
    @Column(name = "password")
    private String password;
    @ManyToMany
    private Set<Role> roleList = new HashSet<>();
}
