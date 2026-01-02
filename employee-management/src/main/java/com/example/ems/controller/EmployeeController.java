package com.example.ems.controller;

import com.example.ems.dto.CreateEmployeeDTO;
import com.example.ems.dto.EmployeeResponseDTO;
import com.example.ems.dto.UpdateEmployeeDTO;
import com.example.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(createEmployeeDTO));
    }


    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    //Valid without this validation won't work
    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody UpdateEmployeeDTO employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
