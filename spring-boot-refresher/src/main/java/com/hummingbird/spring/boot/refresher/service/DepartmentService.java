package com.hummingbird.spring.boot.refresher.service;

import com.hummingbird.spring.boot.refresher.entity.Department;
import com.hummingbird.spring.boot.refresher.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException;

    void deleteDepartmentByID(Long departmentID);

    public Department updateDepartment(Long departmentID, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
