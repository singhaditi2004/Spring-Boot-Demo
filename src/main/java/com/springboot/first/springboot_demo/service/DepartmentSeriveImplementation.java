package com.springboot.first.springboot_demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.springboot_demo.entity.Department;
import com.springboot.first.springboot_demo.error.DepartmentNotFoundException;
import com.springboot.first.springboot_demo.repostitiory.DepartmentRepo;

@Service
public class DepartmentSeriveImplementation implements DepartmentService {
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
	public Department fetchDepartByid(Long departemntId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department= departRepo.findById(departemntId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not available");
		}
		return  department.get();
	}

	@Override
	public void deleteDepartmentById(Long departemntId) {
		// TODO Auto-generated method stub
		departRepo.deleteById(departemntId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department depart) {
		// TODO Auto-generated method stub
		Department db = departRepo.findById(departmentId).get();
		if (Objects.nonNull(depart.getDepartmentName()) && !"".equalsIgnoreCase(depart.getDepartmentName())) {
			db.setDepartmentName(depart.getDepartmentName());
		}
		if (Objects.nonNull(depart.getDepartmentCode()) && !"".equalsIgnoreCase(depart.getDepartmentName())) {
			db.setDepartmentName(depart.getDepartmentCode());
		}
		if (Objects.nonNull(depart.getdAdd()) && !"".equalsIgnoreCase(depart.getDepartmentName())) {
			db.setDepartmentName(depart.getdAdd());
		}
		return departRepo.save(db);
	}

	@Override
	public Department fetchDepartByName(String dname) {
		return departRepo.findByDepartmentName(dname);
	}

}
