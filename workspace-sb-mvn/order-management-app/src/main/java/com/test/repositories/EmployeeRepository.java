package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entities.Employee;

// 따로 쿼리문을 작성하지 않아도 기본적인 CRUD 기능 제공
public interface EmployeeRepository extends JpaRepository<Employee, String> {}
