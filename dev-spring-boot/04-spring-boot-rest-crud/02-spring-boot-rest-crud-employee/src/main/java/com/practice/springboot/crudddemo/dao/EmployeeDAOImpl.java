package com.practice.springboot.crudddemo.dao;

import com.practice.springboot.crudddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
// define field for entity manager
    private EntityManager entityManager;

//    constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
//        create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
//        execute and get results
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee); // if id is 0 then create or update
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
       Employee employee = entityManager.find(Employee.class, theId);
       entityManager.remove(employee);
    }
}
