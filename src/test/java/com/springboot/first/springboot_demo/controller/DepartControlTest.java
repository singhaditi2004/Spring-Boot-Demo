package com.springboot.first.springboot_demo.controller;

import static org.junit.jupiter.api.Assertions.*;

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

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.service.DepartmentService;

@WebMvcTest(DepartControlTest.class)
class DepartControlTest {
	@Autowired
	private MockMvc mockMVC;
	@MockBean
	private DepartmentService departSEr;
    private Department depart;
    
	@BeforeEach
	void setUp() {
		depart=Department.builder()
				.dAdd("DELHI")
				.departmentCode("IT-56")
				.departmentId(12L)
				.departmentName("IT")
				.build();
	}

	@Test
	void saveDepartment() throws Exception {
		Department inpdepart=Department.builder()
				.dAdd("Bombay")
				.departmentCode("IT-56")
				.departmentId(12L)
				.departmentName("IT")
				.build();
		Mockito.when(departSEr.saveDepartment(inpdepart)).thenReturn(depart);
		mockMVC.perform(MockMvcRequestBuilders.post("")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"\t\"departmentName\":\"IT\",\n" +
						"\t\"departmentAddress\":\"Ahmedabad\", \n" +
						"\t\"departmentCode\":\"IT-06\"\n" +
						"}"))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void fetchDepartById() {
		
	}
}
