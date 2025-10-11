package com.practice.springboot.crudddemo.service;

import com.practice.springboot.crudddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int theId);

}
