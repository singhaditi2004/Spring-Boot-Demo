package com.springboot.first.springboot_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.service.DepartmentSeriveImplementation;
import com.springboot.first.springboot_demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class Controller {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {

		return departmentService.saveDepartment(department);

	}

	public List<Department> fetchDepartList() {
		return departmentService.fetchDepartList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepartByid(@PathVariable("id") Long departemntId) {
		return departmentService.fetchDepartByid(departemntId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departemntId) {
		departmentService.deleteDepartmentById(departemntId);
		return "Department deleted successfully";
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department depart) {
		return departmentService.updateDepartment(departmentId, depart);
	}

	@GetMapping("/departments/name/{name}")
	public Department fetchDepartByName(@PathVariable("name") String dname) {
		return departmentService.fetchDepartByName(dname);

	}
}
