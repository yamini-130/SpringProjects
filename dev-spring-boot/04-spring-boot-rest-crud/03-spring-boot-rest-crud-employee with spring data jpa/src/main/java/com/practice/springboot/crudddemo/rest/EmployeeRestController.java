package com.practice.springboot.crudddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.practice.springboot.crudddemo.entity.Employee;
import com.practice.springboot.crudddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService,ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper; // pre configured by spring boot
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("employee with id " + employeeId + " not found");
        }

        return employee;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        ///  also just in case they pass an is in json... set id to 0
        ///  this is force a save of new item.. instead of update
        employee.setId(0);
        Employee theEmployee = employeeService.save(employee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
     Employee theEmployee = employeeService.save(employee);
     return theEmployee;
    }

//    add mapping for Patch /employees {employeeId} -patch employee .. partial update

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee tempEmployee = employeeService.findById(employeeId);
// throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("employee with id " + employeeId + " not found");
        }
// throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id is not allowed in the request body -" + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload,tempEmployee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
//        convert employee object to a json object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

//        convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

//        Merge the patch updated into the employee node
        employeeNode.setAll(patchNode);

//        convert the json object node back tp employee object
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("employee with id " + employeeId + " not found");
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
