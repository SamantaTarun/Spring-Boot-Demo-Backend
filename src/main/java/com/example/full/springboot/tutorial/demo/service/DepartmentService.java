package com.example.full.springboot.tutorial.demo.service;

import com.example.full.springboot.tutorial.demo.entity.Department;
import com.example.full.springboot.tutorial.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);

}
