package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
