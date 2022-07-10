package com.example.full.springboot.tutorial.demo.repository;


import com.example.full.springboot.tutorial.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //vvi- video time: 1:23:55
    Department findBydepartmentName(String departmentName);

    Department findBydepartmentNameIgnoreCase(String departmentName);

}
