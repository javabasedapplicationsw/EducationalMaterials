package com.test.services;

import com.test.entities.Department;

public interface DepartmentService {
	public Department saveDepartment(Department department);
	public Department getDepartmentById(Long departmentId);
}
