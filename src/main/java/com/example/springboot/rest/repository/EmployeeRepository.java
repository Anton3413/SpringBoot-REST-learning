package com.example.springboot.rest.repository;


import com.example.springboot.rest.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

   List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Optional<Employee> getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
