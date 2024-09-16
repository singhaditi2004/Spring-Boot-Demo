package com.springboot.first.springboot_demo.service;

import java.util.List;

import com.springboot.first.springboot_demo.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartList();

	public Department fetchDepartByid(Long departemntId);

	public void deleteDepartmentById(Long departemntId);

	public Department updateDepartment(Long departmentId, Department depart);

	public Department fetchDepartByName(String dname);

}
