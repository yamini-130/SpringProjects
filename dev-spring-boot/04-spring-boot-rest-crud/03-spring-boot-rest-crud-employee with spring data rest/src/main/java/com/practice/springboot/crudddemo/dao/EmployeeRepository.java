package com.practice.springboot.crudddemo.dao;

import com.practice.springboot.crudddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members") // path will be magic-api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
