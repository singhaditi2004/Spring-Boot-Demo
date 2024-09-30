package com.springboot.first.springboot_demo.reposititory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.repostitiory.DepartmentRepo;

class DepartmentRepositioryTest {
	@Autowired
	private DepartmentRepo departRepos;
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp(){
		Department deparn=Department.builder()
				              .departmentName("Mechanical")
				              .dAdd("HHHHHHHHHHHHHH")
				              .departmentCode("ME-121")
				              .build();
		
		entityManager.persist(deparn);		             
	}
	
	@Test
	public void whenFindById_thenReturnDepartment() {
		Department department=departRepos.findById(1L).get();
		assertEquals(department.getDepartmentName(),"Mechanical");
	}

}
