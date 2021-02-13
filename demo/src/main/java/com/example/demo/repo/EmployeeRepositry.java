package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositry extends JpaRepository<Employee, Long> {

}
