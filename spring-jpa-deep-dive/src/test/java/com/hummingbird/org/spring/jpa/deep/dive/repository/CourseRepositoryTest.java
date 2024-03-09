package com.hummingbird.org.spring.jpa.deep.dive.repository;

import com.hummingbird.org.spring.jpa.deep.dive.entity.Course;
import com.hummingbird.org.spring.jpa.deep.dive.entity.Student;
import com.hummingbird.org.spring.jpa.deep.dive.entity.Teacher;
import org.apache.commons.text.RandomStringGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private static String generateRandomEmail() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build();

        String firstName = generator.generate(5); // Generate a random first name with 5 characters
        String lastName = generator.generate(5);  // Generate a random last name with 5 characters
        String domain = "jaba.com";

        return firstName + "." + lastName + "@" + domain;
    }

    @Test
    public void getAllCourses() {
        List<Course> courseList = courseRepository.findAll();

        System.out.println("Course list with materials: " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Rajab")
                .lastName("Khan")
                .build();

        Course course = Course.builder()
                .title("Javascript")
                .credit(9)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagedCourses() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println("Paginated Courses list: "+ courses);

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        System.out.println("Total Elements = " + totalElements);

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("Total Pages = " + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(
                0, 2, Sort.by("title")
        );

        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title")
                .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("Sort By TITLE Courses = " + courses);

        List<Course> coursesSortedByCreditDesc = courseRepository.findAll(sortByCreditDesc).getContent();

        System.out.println("Sort By CREDIT DESC Courses = " + coursesSortedByCreditDesc);

        List<Course> coursesSortByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("Sort By TITLE AND CREDIT DESC Courses = " + coursesSortByTitleAndCreditDesc);
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPagedTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("Ja", firstPagedTenRecords).getContent();

        System.out.println("Courses containing 'Ja' = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizzie")
                .lastName("Mannings")
                .build();

        Student student = Student.builder()
                .firstName("Masjid")
                .lastName("Masjid")
                .emailId(generateRandomEmail())
                .build();

        Course course = Course.builder()
                .title("Quantum Physics")
                .credit(8)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }
}