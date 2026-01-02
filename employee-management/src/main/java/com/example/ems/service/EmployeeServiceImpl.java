package com.example.ems.service;

import com.example.ems.dto.CreateEmployeeDTO;
import com.example.ems.dto.EmployeeResponseDTO;
import com.example.ems.dto.UpdateEmployeeDTO;
import com.example.ems.entity.Employee;
import com.example.ems.exception.DuplicateResourceException;
import com.example.ems.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(CreateEmployeeDTO dto) {
        if (employeeRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("Employee with email " + dto.getEmail() + " already exists");
        }
        Employee employee = mapToEntity(dto);
        Employee saved = employeeRepository.save(employee);
        return mapToResponseDto(saved);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
      return employeeRepository.findAll().stream().map(this::mapToResponseDto).toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));
        return mapToResponseDto(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, UpdateEmployeeDTO dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());

        Employee saved = employeeRepository.save(existing);
        return mapToResponseDto(saved);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));
        employeeRepository.delete(employee);
    }

    private EmployeeResponseDTO mapToResponseDto(Employee emp) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(emp.getId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());
        dto.setDepartment(emp.getDepartment());
        dto.setSalary(emp.getSalary());
        return dto;
    }

    private Employee mapToEntity(CreateEmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        return emp;
    }
}
