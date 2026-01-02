package com.example.ems.dto;

import jakarta.validation.constraints.Positive;

public class UpdateEmployeeDTO {
    private String firstName;
    private String lastName;
    private String department;
    @Positive(message = "Salary must be greater than 0")
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
