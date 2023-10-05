package com.example.springboot.rest.service;


import com.example.springboot.rest.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);

}
