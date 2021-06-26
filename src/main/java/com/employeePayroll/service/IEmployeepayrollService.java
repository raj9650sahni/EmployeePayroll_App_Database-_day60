package com.employeePayroll.service;

import java.awt.List;

import com.employeePayroll.DTO.EmployeePayrollDTO;
import com.employeePayroll.model.EmployeePayrollData;

public interface IEmployeepayrollService {
	
	java.util.List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empid);
	
	java.util.List<EmployeePayrollData> getEmployeesByDepartment(String department);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	
	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);
	
	void deleteEmployeepayrollData(int empId);
	

}
