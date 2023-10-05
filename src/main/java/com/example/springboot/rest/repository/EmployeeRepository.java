package com.example.springboot.rest.repository;


import com.example.springboot.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
