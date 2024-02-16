package com.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.Employee;
import com.test.services.EmployeeService;
import com.test.services.ResponseDto;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
		ResponseDto responseDto = employeeService.getEmployee(employeeId);
		return ResponseEntity.ok(responseDto);
	}
}












