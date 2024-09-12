package com.springboot.first.springboot_demo.repostitiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.springboot_demo.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
