package com.test.services;

import java.util.List;

import com.test.entities.Employee;

public interface EmployeeService {

	public List<Employee> getEmployeeAll();
	public Employee getEmployeeById(String employId);
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(String employeeId, Employee employee);
	public void deleteEmployee(String employeeId);
}
