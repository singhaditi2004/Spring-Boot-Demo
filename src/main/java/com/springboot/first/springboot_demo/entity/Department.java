package com.springboot.first.springboot_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	@NotBlank(message= "Please add Department name")
	private String departmentName;
	private String dAdd;
	private String departmentCode;
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", dAdd=" + dAdd
				+ ", departmentCode=" + departmentCode + "]";
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long departmentId, String departmentName, String dAdd, String departmentCode) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.dAdd = dAdd;
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getdAdd() {
		return dAdd;
	}

	public void setdAdd(String dAdd) {
		this.dAdd = dAdd;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	

}
