package com.hummingbird.spring.boot.refresher.controller;

import com.hummingbird.spring.boot.refresher.entity.Department;
import com.hummingbird.spring.boot.refresher.error.DepartmentNotFoundException;
import com.hummingbird.spring.boot.refresher.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("One Padmore Place")
                .departmentCode("IT-06")
                .departmentID(1L)
                .build();
    }

    @Test
    @DisplayName("Save department")
    void saveDepartment() throws Exception {
        Department departmentInput = Department.builder()
                .departmentName("IT")
                .departmentAddress("One Padmore Place")
                .departmentCode("IT-06")
                .build();

        Mockito.when(departmentService.saveDepartment(departmentInput)).thenReturn(department);

        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"IT\",\n" +
                        "    \"departmentAddress\": \"One Padmore Place\",\n" +
                        "    \"departmentCode\": \"IT-06\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get department by ID")
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentByID(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}