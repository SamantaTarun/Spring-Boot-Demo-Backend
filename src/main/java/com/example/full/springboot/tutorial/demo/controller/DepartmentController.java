package com.example.full.springboot.tutorial.demo.controller;


import com.example.full.springboot.tutorial.demo.entity.Department;
import com.example.full.springboot.tutorial.demo.error.DepartmentNotFoundException;
import com.example.full.springboot.tutorial.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER=
            LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside FETCHDepartment of DepartmentContrller");
        return departmentService.fetchDepartmentList();
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentContrller");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){

        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){

        return departmentService.updateDepartment(departmentId,department);
    }


    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);
    }


}
