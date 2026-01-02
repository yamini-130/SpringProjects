package com.example.ems.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        }
)
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable=false)
    private String firstName;

    @Column(name="last_name",nullable=false)
    private String lastName;

    @Column(name="email",unique =true,nullable=false )
    private String email;

    @Column(name="department")
    private String department;

    @Column(name="salary")
    private Double salary;

    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
