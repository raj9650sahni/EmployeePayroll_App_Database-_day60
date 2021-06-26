package com.employeePayroll.service;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeePayroll.DTO.EmployeePayrollDTO;
import com.employeePayroll.exceptions.EmployeePayrollException;
import com.employeePayroll.model.EmployeePayrollData;
import com.employeePayroll.repositary.EmployeePayrollRepositary;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeepayrollService implements IEmployeepayrollService {
	
	
	@Autowired
	private EmployeePayrollRepositary employeeRepositary;
	
	
	@Override
	public java.util.List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepositary.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		return employeeRepositary.findById(empid)
				.orElseThrow( () ->  new EmployeePayrollException("Employee with employeeID" + empid + "does not exist"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empdata=null;
		empdata = new EmployeePayrollData(empPayrollDTO);
		log.debug("emp Data : "+ empdata.toString());
		return employeeRepositary.save(empdata);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empdata= this.getEmployeePayrollDataById(empId);
		empdata.updateEmployeePayrollData(empPayrollDTO);
		return employeeRepositary.save(empdata);
	
	}

	@Override
	public void deleteEmployeepayrollData(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeeRepositary.delete(empData);
		
	}

	@Override
	public java.util.List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepositary.findEmployeesByDepartment(department);
	}

	


}
