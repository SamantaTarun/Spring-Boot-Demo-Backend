package com.example.full.springboot.tutorial.demo.service;

import com.example.full.springboot.tutorial.demo.entity.Department;
import com.example.full.springboot.tutorial.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){

        Department department=
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Kolkata")
                        .departmentCode("IT-23")
                        .departmentId(7L)
                        .build();



        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("get Data based on department Name")
    public void whenValidDepartmentName_ThenDepartmentShouldFound(){

        String departmentName= "IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        Assertions.assertEquals(departmentName,found.getDepartmentName());


    }


}