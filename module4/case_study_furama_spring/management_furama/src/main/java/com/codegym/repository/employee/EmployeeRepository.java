package com.codegym.repository.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

    @Query(value = "select * from employee where employee_name like %?1%",nativeQuery = true)
    Page<Employee>findAllByEmployeeName(Pageable pageable,String nameEmployee);


}
