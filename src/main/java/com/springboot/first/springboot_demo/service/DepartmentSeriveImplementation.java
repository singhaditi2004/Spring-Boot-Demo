package com.springboot.first.springboot_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.repostitiory.DepartmentRepo;

@Service
public class DepartmentSeriveImplementation implements DepartmentService{
    @Autowired
	private DepartmentRepo departRepo;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departRepo.save(department);
	}
	@Override
	public List<Department> fetchDepartList() {
		// TODO Auto-generated method stub
		return departRepo.findAll();
	}
	@Override
	public Department fetchDepartByid(Long departemntId) {
		// TODO Auto-generated method stub
		return departRepo.findById(departemntId).get();
	}

}
