package edu.miu.attendance.util;

import edu.miu.attendance.domain.*;
import edu.miu.attendance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RoleRepository roleDAO;

    @Autowired
    StudentRepository studentDAO;

    @Autowired
    FacultyRepository facultyDAO;

    @Autowired
    CourseRepository courseDAO;

    @Autowired
    TimeSlotRepository timeSlotDAO;

    @Autowired
    CourseOfferingRepository courseOfferingDAO;

    @Autowired
    CourseSessionRepository courseSessionDAO;

    @Autowired
    RegistrationRepository registrationDAO;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createTimeSlots();
        createStudents();
        createFaculties();
        createCourses();
        courseOfferings();
        createSessions();
        registerStudents();


    }
    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN");
        Role rolePERSONNEL = new Role(2,"ROLE_PERSONNEL");
        Role roleSTUDENT = new Role(3,"ROLE_STUDENT");
        Role roleFACULTY = new Role(3,"ROLE_FACULTY");


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
        System.out.println(studentDAO.findAll().toString());
    }
    private void createFaculties(){
        Faculty faculty = new Faculty();
        faculty.setFirstName("testprof");
        faculty.setLastName("test");
        faculty.setEmail("prof@gmail.com");
        faculty.setUsername("prof");
        faculty.setPassword("123");
        faculty.setPosition("Professor");

        Faculty faculty1= new Faculty();
        faculty1.setFirstName("testprof1");
        faculty1.setLastName("test");
        faculty1.setEmail("prof@gmail.com");
        faculty1.setUsername("prof");
        faculty1.setPassword("123");
        faculty.setPosition("Teaching Assistant");

        facultyDAO.saveAll(Arrays.asList(faculty, faculty1));
        System.out.println("id" + faculty.getId());
        System.out.println(facultyDAO.findAll().toString());
    }
    private void registerStudents(){
        Optional<Student> student1 = studentDAO.findById(1L);
        Optional<CourseOffering> EACourseOffering = courseOfferingDAO.findById(1L);

        Optional<Student> student2 = studentDAO.findById(2L);
        Optional<CourseOffering> WAACourseOffering = courseOfferingDAO.findById(2L);

        Registration registration = new Registration();
        registration.setStudent(student1.get());
        registration.setCourseOffering(EACourseOffering.get());

        Registration registration1 = new Registration();
        registration1.setStudent(student2.get());
        registration1.setCourseOffering(WAACourseOffering.get());

        registrationDAO.saveAll(Arrays.asList(registration, registration1));
        System.out.println(registrationDAO.findAll().toString());
    }

    private void courseOfferings(){
        Optional<Course> ea = courseDAO.findById(1L);
        Optional<Faculty> faculty = facultyDAO.findById(3L);
        System.out.println("faculty" + faculty);

        CourseOffering courseOffering = new CourseOffering();
        courseOffering.setStart_date(LocalDate.of(2021,5,12));
        courseOffering.setEnd_date(LocalDate.of(2021,6,10));
        courseOffering.setCourse(ea.get());
        courseOffering.setFaculty(faculty.get());

        Optional<Course> waa = courseDAO.findById(2L);
        Optional<Faculty> faculty1 = facultyDAO.findById(4L);

        CourseOffering courseOffering1 = new CourseOffering();
        courseOffering1.setStart_date(LocalDate.of(2021,4,12));
        courseOffering1.setEnd_date(LocalDate.of(2021,5,10));
        courseOffering1.setCourse(waa.get());
        courseOffering1.setFaculty(faculty1.get());

        courseOfferingDAO.saveAll(Arrays.asList(courseOffering, courseOffering1));
        System.out.println(courseOfferingDAO.findAll().toString());
    }

    private void createCourses(){
        Course course1 = new Course();
        course1.setName("Enterprise Architecture");
        course1.setDescription("Architecture");
        course1.setCode("CS-544-2021-06C");

        Course course2 = new Course();
        course2.setName("Web Architecture");
        course2.setDescription("Web Architecture");
        course2.setCode("CS-545-2021-06C");

        courseDAO.saveAll(Arrays.asList(course1, course2));
        System.out.println(courseDAO.findAll().toString());

    }
    private void createTimeSlots(){
        TimeSlot morningSlot = new TimeSlot();
        morningSlot.setBeginTime(LocalTime.of(10,0,0));
        morningSlot.setEndTime(LocalTime.of(12,30,0));
        morningSlot.setDescription("This is morning slot");

        TimeSlot afternoonSlot = new TimeSlot();
        afternoonSlot.setBeginTime(LocalTime.of(10,0,0));
        afternoonSlot.setEndTime(LocalTime.of(12,30,0));
        afternoonSlot.setDescription("This is afternoon slot");

        timeSlotDAO.saveAll(Arrays.asList(morningSlot, afternoonSlot));
        System.out.println(timeSlotDAO.findAll().toString());
    }

    private void createSessions(){
        Optional<CourseOffering> courseOffering = courseOfferingDAO.findById(1L);
        TimeSlot timeSlot = timeSlotDAO.getById(1L);
        CourseSession AMSession = new CourseSession();
        AMSession.setDate(LocalDate.now());
        AMSession.setTimeSlot(timeSlot);
        AMSession.setCourseOffering(courseOffering.get());

        TimeSlot timeSlot2 = timeSlotDAO.getById(2L);
        CourseSession PMSession = new CourseSession();
        PMSession.setDate(LocalDate.now());
        PMSession.setTimeSlot(timeSlot2);
        PMSession.setCourseOffering(courseOffering.get());

        courseSessionDAO.saveAll(Arrays.asList(AMSession, PMSession));
        System.out.println(courseSessionDAO.findAll().toString());
    }

}