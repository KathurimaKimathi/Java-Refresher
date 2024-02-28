package com.hummingbird.spring.boot.refresher.controller;

import com.hummingbird.spring.boot.refresher.entity.Department;
import com.hummingbird.spring.boot.refresher.error.DepartmentNotFoundException;
import com.hummingbird.spring.boot.refresher.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByID(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long departmentID) {
        departmentService.deleteDepartmentByID(departmentID);

        return "Department successfully deleted!";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentID, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
