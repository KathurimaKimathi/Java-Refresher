package com.hummingbird.spring.boot.refresher.repository;

import com.hummingbird.spring.boot.refresher.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Aeronautics")
                .departmentAddress("One Padmore Place")
                .departmentCode("AERO-06")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("Get department by ID")
    public void findDepartmentByID() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("Aeronautics", department.getDepartmentName());
    }
}