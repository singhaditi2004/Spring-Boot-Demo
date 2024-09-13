package com.springboot.first.springboot_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.service.DepartmentSeriveImplementation;
import com.springboot.first.springboot_demo.service.DepartmentService;

@RestController
public class Controller {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		
		
		return departmentService.saveDepartment(department);
		
	}

}
