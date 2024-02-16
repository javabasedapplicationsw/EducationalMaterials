package com.test.services;

import com.test.entities.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public ResponseDto getEmployee(Long employeeId);
	
}
