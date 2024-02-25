package com.hummingbird.spring.boot.refresher.service;

import com.hummingbird.spring.boot.refresher.entity.Department;
import com.hummingbird.spring.boot.refresher.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("One Padmore Place")
                .departmentCode("IT-06")
                .departmentID(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get department data with valid department name")
    public void findDepartmentWithAValidDepartmentName() {
        String departmentName = "IT";

        Department foundDepartment = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}