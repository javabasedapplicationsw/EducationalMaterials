package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
