package com.example.springboot.rest.repository;


import com.example.springboot.rest.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private EntityManager manager;

    public List<Employee> getAllEmployees() {

       Query query = manager.createQuery("from Employee ");
       return query.getResultList();
    }

    public void saveEmployee(Employee employee) {
        manager.merge(employee);
    }

   public Optional<Employee> getEmployeeById(int id) {
      Optional<Employee> employee =
              Optional.ofNullable(manager.find(Employee.class,id));
      return employee;
    }

    public void deleteEmployeeById(int id) {
        Optional<Employee>  employee = getEmployeeById(id);
            manager.remove(employee.orElseThrow(
            ()->  new EntityNotFoundException("Its impossible to delete an employee with ID = "+ id)));

    }
}
