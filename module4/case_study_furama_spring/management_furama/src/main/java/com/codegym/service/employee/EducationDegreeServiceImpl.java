package com.codegym.service.employee;

import com.codegym.entity.employee.EducationDegree;
import com.codegym.repository.employee.EducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return this.educationDegreeRepository.findAll();
    }
}
