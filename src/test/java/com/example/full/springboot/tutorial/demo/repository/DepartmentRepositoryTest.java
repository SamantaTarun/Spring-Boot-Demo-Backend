package com.example.full.springboot.tutorial.demo.repository;

import com.example.full.springboot.tutorial.demo.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.testng.asserts.Assertion;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department=
                Department.builder()
                        .departmentName("ME")
                        .departmentCode("ME-01")
                        .departmentAddress("Kolkata")
                        .build();
        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){

        Department department=departmentRepository.findById(1L).get();
        Assertions.assertEquals(department.getDepartmentName(), "ME");
    }
}