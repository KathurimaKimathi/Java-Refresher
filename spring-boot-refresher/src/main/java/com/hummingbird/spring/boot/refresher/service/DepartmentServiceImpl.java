package com.hummingbird.spring.boot.refresher.service;

import com.hummingbird.spring.boot.refresher.entity.Department;
import com.hummingbird.spring.boot.refresher.error.DepartmentNotFoundException;
import com.hummingbird.spring.boot.refresher.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentID);

        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentByID(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {
        Department record = departmentRepository.findById(departmentID).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            record.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            record.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            record.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(record);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
