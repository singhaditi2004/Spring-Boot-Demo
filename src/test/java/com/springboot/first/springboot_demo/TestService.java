package com.springboot.first.springboot_demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.repostitiory.DepartmentRepo;
import com.springboot.first.springboot_demo.service.DepartmentService;
@SpringBootTest
class TestService {
	@Autowired
    private DepartmentService departService;
	@MockBean
	private DepartmentRepo departRepo;
	
	@BeforeEach
	void setUp() {
		Department depart=Department.builder()
				          .departmentName("IT")
				          .departmentCode("IT-23")
				          .departmentId(1L)
				          .dAdd("H>NO 123")
				          .build();
		Mockito.when(departRepo.findByDepartmentName("IT")).thenReturn(depart);
	}
	@Test
	@DisplayName("Get Data based on valid Depatment name")
	public void whenValidDepartmentName(String dname) {
		String departName="IT";
	    Department found=departService.fetchDepartByName(departName);
	    assertEquals(departName, found.getDepartmentName());;
	    
	}
}
