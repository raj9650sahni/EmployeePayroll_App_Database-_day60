package com.employeePayroll.exceptions;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employeePayroll.DTO.ResponseDTO;
import com.sun.tools.sjavac.Log;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
	
	
	private static final String message = "Exception while processing rest Request";
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		Log.error("Invalid date format   :"+ exception);
		ResponseDTO responseDTO = new ResponseDTO(message,"should have date in the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException( MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		java.util.List<String> errMesg=errorList.stream()
										.map(objErr -> objErr.getDefaultMessage())
										.collect(Collectors.toList());
		
		ResponseDTO responseDTO = new ResponseDTO(message, errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception) {
		ResponseDTO responseDTO = new ResponseDTO(message,exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	

}
