package com.example.springboot.rest.service;


import com.example.springboot.rest.model.Employee;
import com.example.springboot.rest.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {

        return employeeRepository.findById(id)
                .orElseThrow(
                () ->new EntityNotFoundException("There is no Employee with id = " + id));
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
