package com.codegym.service.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee>findAllByNameEmployee(Pageable pageable,String employeeName);
    void save(Employee employee);
    void deleteEmployeeById(String idEmployee);
    Employee findEmployeeById(String idEmployee);
    List<Employee>findAll();

}
