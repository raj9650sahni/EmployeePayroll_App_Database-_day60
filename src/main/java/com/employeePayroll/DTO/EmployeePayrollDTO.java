package com.employeePayroll.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import com.sun.istack.NotNull;

import lombok.ToString;

//import javax.validation.constraints.Pattern;

public @ToString class EmployeePayrollDTO {

	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee Name Invalid")
	public String name;
	@Min(value=500,message = "Min Wage Should be more than 500")
	public long salary;
	
	public String gender;
	
	public String profilePic;
	public List<String> department;
	public LocalDate startDate;
	public String note;
	
	
	public EmployeePayrollDTO(String name,long salary) {
		
		
		this.name= name;
		this.salary=salary;
	}
}
	