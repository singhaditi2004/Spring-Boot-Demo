package com.springboot.first.springboot_demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.springboot_demo.entity.Department;

@RestController
public class Controller {
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		
		return department;
		
	}

}
