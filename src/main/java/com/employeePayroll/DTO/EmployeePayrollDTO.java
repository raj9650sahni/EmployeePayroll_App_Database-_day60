package com.employeePayroll.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

//import javax.validation.constraints.Pattern;

public @ToString class EmployeePayrollDTO {

	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee Name Invalid")
	public String name;
	@Min(value=500,message = "Min Wage Should be more than 500")
	public long salary;
	
	@Pattern(regexp = "male|female", message = "Gender needs to be male and female")
	public String gender;
	
	@NotBlank(message = "profilePic cannot be empty")
	public String profilePic;
	
	@javax.validation.constraints.NotNull(message = "Department should not be empty")
	public List<String> department;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "startDate should not be empty")
	@PastOrPresent(message = "startDAte should be past dates or todays Date")
	public LocalDate startDate;
	
	@NotBlank(message = "note cannot be empty")
	public String note;
	
	
	public EmployeePayrollDTO(String name,long salary) {
		
		
		this.name= name;
		this.salary=salary;
	}
}
	