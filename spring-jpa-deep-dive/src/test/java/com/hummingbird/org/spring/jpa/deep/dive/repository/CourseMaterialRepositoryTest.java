package com.hummingbird.org.spring.jpa.deep.dive.repository;

import com.hummingbird.org.spring.jpa.deep.dive.entity.Course;
import com.hummingbird.org.spring.jpa.deep.dive.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Data Structure and Algorithms")
                .credit(8)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.mit.ac.us")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllMaterialCourses() {
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();

        System.out.println("Course Materials = " + courseMaterialList);
    }
}