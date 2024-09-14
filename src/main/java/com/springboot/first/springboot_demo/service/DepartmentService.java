package com.springboot.first.springboot_demo.service;

import java.util.List;

import com.springboot.first.springboot_demo.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartList();

	public Department fetchDepartByid(Long departemntId);

}
