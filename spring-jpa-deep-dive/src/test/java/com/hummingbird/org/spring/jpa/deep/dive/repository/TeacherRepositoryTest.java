package com.hummingbird.org.spring.jpa.deep.dive.repository;

import com.hummingbird.org.spring.jpa.deep.dive.entity.Course;
import com.hummingbird.org.spring.jpa.deep.dive.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        List<Course> courseList = List.of(
                Course.builder()
                        .title("Java")
                        .credit(7)
                        .build(),
                Course.builder()
                        .title("Functional Programming")
                        .credit(9)
                        .build());

        Teacher teacher = Teacher.builder()
                .lastName("Teacher")
                .firstName("Kamau")
//                .courses(courseList)
                .build();

        teacherRepository.save(teacher);
    }

}