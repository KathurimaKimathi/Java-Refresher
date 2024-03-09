package com.hummingbird.org.spring.jpa.deep.dive.repository;

import com.hummingbird.org.spring.jpa.deep.dive.entity.Guardian;
import com.hummingbird.org.spring.jpa.deep.dive.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // Use this since we want to persist the data in the database. Otherwise, use @DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    public void saveStudent() {
//        Student student = Student.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .emailId("john@does.com")
////                .guardianName("Jane Doe")
////                .guardianEmail("guardian@janes.com")
////                .guardianMobile("1234567890")
//                .build();
//
//        studentRepository.save(student);
//    }

//    @Test
//    public void createStudentWithGuardian() {
//        Guardian guardian = Guardian.builder()
//                .name("Jane Doe")
//                .email("jenny@keg.org")
//                .mobile("1234567890")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .emailId("johnny@keg.com")
//                .guardian(guardian)
//                .build();
//
//        studentRepository.save(student);
//    }

//    @Test
//    public void getAllStudents() {
//        List<Student> studentList = studentRepository.findAll();
//
//        System.out.println("Students: " + studentList);
//    }
//
//    @Test
//    public void getStudentByFirstName() {
//        List<Student> studentList = studentRepository.findByFirstName("John");
//
//        System.out.println("Students: " + studentList);
//    }
//
//    @Test
//    public void getStudentByFirstNameContaining() {
//        List<Student> studentList = studentRepository.findByFirstNameContaining("Ke");
//
//        System.out.println("Students Containing: " + studentList);
//    }
//
//    @Test
//    public void getStudentByLastNameNotNull() {
//        List<Student> studentList = studentRepository.findByLastNameNotNull();
//
//        System.out.println("Students with last name not null: " + studentList);
//    }
//
//    @Test
//    public void getStudentByGuardianName() {
//        List<Student> studentList = studentRepository.findByGuardianName("Luke Doe");
//
//        System.out.println("Students with guardian name: " + studentList);
//    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("jenny@keg.org");

        System.out.println("Student with email address: " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("johnny@keg.com");

        System.out.println("First name of student with email address: " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("johnny@keg.com");

        System.out.println("Student with email address (Native): " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParams() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParams("johnny@keg.com");

        System.out.println("Student with email address (Native with named params): " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Hilson", "johnny@keg.com");

    }

}