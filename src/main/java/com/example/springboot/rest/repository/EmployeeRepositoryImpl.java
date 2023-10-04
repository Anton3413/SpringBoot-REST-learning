package com.example.springboot.rest.repository;


import com.example.springboot.rest.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private EntityManager manager;

    public List<Employee> getAllEmployees() {
       Query<Employee> query = manager.unwrap(Session.class).createQuery("from Employee ", Employee.class);
       return query.getResultList();
    }

    public void saveEmployee(Employee employee) {
        manager.unwrap(Session.class).saveOrUpdate(employee);
    }

   public Optional<Employee> getEmployeeById(int id) {
      Optional<Employee> employee =  Optional.ofNullable(manager.unwrap(Session.class).get(Employee.class,id));
      return employee;
    }

    public void deleteEmployeeById(int id) {
        Optional<Employee>  employee = getEmployeeById(id);
            manager.unwrap(Session.class).
            remove(employee.orElseThrow(
            ()->  new EntityNotFoundException("Its impossible to delete an employee with ID = "+ id)));

    }
}
