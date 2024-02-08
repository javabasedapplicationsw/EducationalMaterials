package com.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entities.Employee;
import com.test.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployeeAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String employId) {
		return employeeRepository.findById(employId).orElse(null);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(String employeeId, Employee newEmployee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		
		if (optionalEmployee.isPresent()) {
			Employee existingEmployee = optionalEmployee.get();
			existingEmployee.setEmployeeName(newEmployee.getEmployeeName());
			existingEmployee.setSalary(newEmployee.getSalary());
			return employeeRepository.save(existingEmployee);
		} else 
			return null;
	}

	@Override
	public void deleteEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);		
	}

}







