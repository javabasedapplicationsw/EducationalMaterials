package com.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.Employee;
import com.test.services.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getEmployeeAll() {
		return employeeService.getEmployeeAll();
	}
	
	@GetMapping("/{employId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String employId) {
		Employee employee = employeeService.getEmployeeById(employId);
		if (employee != null)
			return new ResponseEntity<>(employee, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// http://127.0.0.1:8083/api/employees/
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	// http://127.0.0.1:8083/api/employees/2
	@PatchMapping("/{employId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String employId, 
													@RequestBody Employee employee)
	{
		Employee updatedEmployee = employeeService.updateEmployee(employId, employee);
		if (updatedEmployee != null)
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// http://127.0.0.1:8083/api/employees/2
	@DeleteMapping("/{employId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String employId) {
		employeeService.deleteEmployee(employId);
		return ResponseEntity.ok().build();
	}
}






























