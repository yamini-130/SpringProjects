package com.practice.springboot.crudddemo.dao;

import com.practice.springboot.crudddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
