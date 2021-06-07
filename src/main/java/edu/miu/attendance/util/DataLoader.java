package edu.miu.attendance.util;

import edu.miu.attendance.domain.Faculty;
import edu.miu.attendance.domain.Role;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.repository.FacultyRepository;
import edu.miu.attendance.repository.RoleRepository;
import edu.miu.attendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.Arrays;

public class DataLoader implements CommandLineRunner {

    @Autowired
    RoleRepository roleDAO;

    @Autowired
    StudentRepository studentDAO;

    @Autowired
    FacultyRepository facultyDAO;

    @Override
    public void run(String... args) throws Exception {
        createRoles();

    }
    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN",null);
        Role rolePERSONNEL = new Role(2,"ROLE_PERSONNEL", null);
        Role roleSTUDENT = new Role(3,"ROLE_STUDENT", null);
        Role roleFACULTY = new Role(3,"ROLE_FACULTY", null);


        roleDAO.saveAll(Arrays.asList(roleAdmin, rolePERSONNEL, roleSTUDENT,roleFACULTY));
        System.out.println(roleDAO.findAll().toString());
    }

    private void createStudents(){
        Student student = new Student();
        student.setFirstName("blen");
        student.setLastName("aklilu");
        student.setEmail("blen@gmail.com");
        student.setUsername("blen");
        student.setPassword("test");
        student.setEntry(LocalDate.now());
        student.setBarcode("abc223");

        Student student1 = new Student();
        student1.setFirstName("blen");
        student1.setLastName("aklilu");
        student1.setEmail("blen@gmail.com");
        student1.setUsername("blen");
        student1.setPassword("test");
        student1.setEntry(LocalDate.now());
        student1.setBarcode("abc223");

        studentDAO.saveAll(Arrays.asList(student, student1));
        System.out.println(roleDAO.findAll().toString());
    }
    private void createFaculties(){
        Faculty faculty = new Faculty();
        faculty.setFirstName("prof");
        faculty.setLastName("test");
        faculty.setEmail("prof@gmail.com");
        faculty.setUsername("prof");
        faculty.setPassword("123");

        Faculty faculty1= new Faculty();
        faculty1.setFirstName("prof");
        faculty1.setLastName("test");
        faculty1.setEmail("prof@gmail.com");
        faculty1.setUsername("prof");
        faculty1.setPassword("123");

        facultyDAO.saveAll(Arrays.asList(faculty, faculty1));
        System.out.println(facultyDAO.findAll().toString());
    }
}
