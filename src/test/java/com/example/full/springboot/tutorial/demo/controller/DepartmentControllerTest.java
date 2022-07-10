package com.example.full.springboot.tutorial.demo.controller;

import com.example.full.springboot.tutorial.demo.entity.Department;
import com.example.full.springboot.tutorial.demo.error.DepartmentNotFoundException;
import com.example.full.springboot.tutorial.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department outputdepartment;


    @BeforeEach
    void setUp(){

       outputdepartment=
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Kolkata")
                        .departmentCode("IT-23")
                        .departmentId(7L)
                        .build();

    }
    @Test
    void saveDepartment() throws Exception {

        Department inputdepartment=
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Kolkata")
                        .departmentCode("IT-23")
                        .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(outputdepartment);


        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "        \"departmentName\":\"IT\",\n" +
                        "        \"departmentAddress\": \"Kolkata\",\n" +
                        "        \"departmentCode\": \"IT-23\"\n" +
                        "    \n" +
                        "        \n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(7L))
                .thenReturn(outputdepartment);

        mockMvc.perform(get("/departments/7")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect( jsonPath("$.departmentName").
//                        value(outputdepartment.getDepartmentName()));
    }
}