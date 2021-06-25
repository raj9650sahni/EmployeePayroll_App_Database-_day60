package com.employeePayroll.model;
import com.employeePayroll.service.EmployeepayrollService;

import java.time.LocalDate;
import java.util.List;

import com.employeePayroll.DTO.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {
	
	private String name;
	private int empId;
	private long salary;
	
	private String gender;
	
	private String profilePic;
	private List<String> department;
	private LocalDate startDate;
	private String note;
	
	
	
	
	public EmployeePayrollData( int empId, EmployeePayrollDTO empPayrollDTO) {
		super();
		
		this.name =empPayrollDTO.name;
		this.empId = empId;
		this.salary =empPayrollDTO.salary;
		this.updateEmployeePayrollData(empPayrollDTO);

	}




	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		super();
		this.name =empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.profilePic = empPayrollDTO.profilePic;
		this.department = empPayrollDTO.department;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		
	}
	
	
	

	
}
