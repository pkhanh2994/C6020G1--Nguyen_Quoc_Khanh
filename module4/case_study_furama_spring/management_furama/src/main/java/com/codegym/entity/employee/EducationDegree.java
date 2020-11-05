package com.codegym.entity.employee;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "education_degree")
public class EducationDegree {
    @Id
    private String education_degree_id;
    private String education_degree_name;
    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    private List<Employee>employeeList;

}
