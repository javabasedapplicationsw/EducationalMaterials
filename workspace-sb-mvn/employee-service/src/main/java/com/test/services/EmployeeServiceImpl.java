package com.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.entities.Employee;
import com.test.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseDto getEmployee(Long employeeId) {
		ResponseDto responseDto = new ResponseDto();
		
		Employee employee = employeeRepository.findById(employeeId).get();
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setDepartmentId(employee.getDepartmentId());
		responseDto.setEmployee(employeeDto);
		
		//http://127.0.0.1:8081/api/departments/3
		ResponseEntity<DepartmentDto> responseEntity =
				restTemplate.getForEntity("http://127.0.0.1:8081/api/departments/" + employee.getDepartmentId(), DepartmentDto.class);	
		DepartmentDto departmentDto = responseEntity.getBody();
		responseDto.setDepartment(departmentDto);
		
		return responseDto;
	}

}












