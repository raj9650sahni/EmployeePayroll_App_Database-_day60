package com.employeePayroll.model;
import com.employeePayroll.service.EmployeepayrollService;

import java.time.LocalDate;
import java.util.List;



import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;



import com.employeePayroll.DTO.EmployeePayrollDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@javax.persistence.Table(name = "employee_payroll")
@NoArgsConstructor
public @Data class EmployeePayrollData {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int empId;
	
	@Column(name = "name")
	private String name;
	
	//@Column(name = "salary")
	private long salary;
	
	
	private String gender;
	private String profilePic;
	private LocalDate startDate;
	private String note;
	
	@ElementCollection
	@CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")	
	private List<String> departments;
	
	
	
	


	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		super();
		this.name =empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.profilePic = empPayrollDTO.profilePic;
		this.departments = empPayrollDTO.department;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		
	}






	public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
			this.name =empPayrollDTO.name;
			this.salary = empPayrollDTO.salary;
			this.gender = empPayrollDTO.gender;
			this.profilePic = empPayrollDTO.profilePic;
			this.departments = empPayrollDTO.department;
			this.startDate = empPayrollDTO.startDate;
			this.note = empPayrollDTO.note;
			
		
	}




	
	
	
	

	
}
