package com.springboot.first.springboot_demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.first.springboot_demo.Controller;
import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.service.DepartmentService;

@WebMvcTest(Controller.class)  // Reference the controller being tested
class DepartControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .dAdd("DELHI")
                .departmentCode("IT-56")
                .departmentId(12L)
                .departmentName("IT")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .dAdd("Bombay")
                .departmentCode("IT-56")
                .departmentId(12L)
                .departmentName("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(Mockito.any(Department.class))).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")  // Correct URL
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"IT\",\n" +
                        "\t\"departmentAddress\":\"Ahmedabad\", \n" +
                        "\t\"departmentCode\":\"IT-06\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartById() throws Exception {
        Mockito.when(departmentService.fetchDepartByid(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))  // Move this inside the perform call
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()))
                .andExpect(jsonPath("$.dAdd").value(department.getdAdd()))
                .andExpect(jsonPath("$.departmentCode").value(department.getDepartmentCode()));
    }

}
