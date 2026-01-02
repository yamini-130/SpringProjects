package com.example.ems.service;

import com.example.ems.dto.CreateEmployeeDTO;
import com.example.ems.dto.EmployeeResponseDTO;
import com.example.ems.dto.UpdateEmployeeDTO;
import com.example.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(CreateEmployeeDTO dto);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, UpdateEmployeeDTO employee);

    void deleteEmployee(Long id);
}
