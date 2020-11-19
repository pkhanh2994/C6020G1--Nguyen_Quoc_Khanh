package com.codegym.service.employee;

import com.codegym.entity.employee.Employee;
import com.codegym.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByNameEmployee(Pageable pageable, String employeeName) {
        return this.employeeRepository.findAllByEmployeeName(pageable, employeeName);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployeeById(String idEmployee) {
        this.employeeRepository.deleteById(idEmployee);

    }

    @Override
    public Employee findEmployeeById(String idEmployee) {
        return this.employeeRepository.findById(idEmployee).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}


