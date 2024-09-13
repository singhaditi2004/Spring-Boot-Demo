package com.springboot.first.springboot_demo.service;

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

}
