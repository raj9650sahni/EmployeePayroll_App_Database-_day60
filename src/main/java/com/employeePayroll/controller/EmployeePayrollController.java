package com.employeePayroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeePayroll.DTO.EmployeePayrollDTO;
import com.employeePayroll.DTO.ResponseDTO;
import com.employeePayroll.model.EmployeePayrollData;
import com.employeePayroll.service.IEmployeepayrollService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeepayrollService employeepayrollService;
	
	@RequestMapping(value = {"/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeepayrollService.getEmployeePayrollData();
		ResponseDTO responseDto = new ResponseDTO("Get call Success", empDataList);
		return new ResponseEntity<ResponseDTO>(responseDto ,HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empPayrolldata = null;
		empPayrolldata = employeepayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO responseDto = new ResponseDTO("Get call Success", empPayrolldata);
		return new ResponseEntity<ResponseDTO>(responseDto ,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department) {
		List<EmployeePayrollData> empList =null;
		empList = employeepayrollService.getEmployeesByDepartment(department);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Id for Successfull", empList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid  @RequestBody EmployeePayrollDTO emppayrollDTO) {
		log.debug("Employee DTO: " + emppayrollDTO.toString());
		EmployeePayrollData employeePayrolldata=null;
		employeePayrolldata = employeepayrollService.createEmployeePayrollData(emppayrollDTO);
		ResponseDTO responseDto = new ResponseDTO("Employee created successfully", employeePayrolldata);
		return new ResponseEntity<ResponseDTO>(responseDto,HttpStatus.OK);
		
	}
		
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO emppayrollDTO, @Valid @PathVariable("empId") int empId){
		EmployeePayrollData employeePayrolldata=null;
		employeePayrolldata = employeepayrollService.updateEmployeePayrollData(empId, emppayrollDTO);
		ResponseDTO responseDto = new ResponseDTO("Employee UpDated successfully", employeePayrolldata);
		return new ResponseEntity<ResponseDTO>(responseDto,HttpStatus.OK);		
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeepayrollService.deleteEmployeepayrollData(empId);
		ResponseDTO responseDto = new ResponseDTO("Employee Deleted Successfully", "Deleted Id :" +empId );
		return new ResponseEntity<ResponseDTO>(responseDto,HttpStatus.OK);
	}

}
