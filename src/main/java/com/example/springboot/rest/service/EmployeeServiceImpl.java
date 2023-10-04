package com.example.springboot.rest.service;


import com.example.springboot.rest.model.Employee;
import com.example.springboot.rest.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee){
        employeeRepository.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {

        return employeeRepository.getEmployeeById(id)
                .orElseThrow(
                () ->new EntityNotFoundException("There is no Employee with id = " + id));
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
