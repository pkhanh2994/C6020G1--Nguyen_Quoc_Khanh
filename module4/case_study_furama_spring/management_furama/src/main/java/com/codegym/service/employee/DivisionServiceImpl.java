package com.codegym.service.employee;

import com.codegym.entity.employee.Division;
import com.codegym.repository.employee.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> findAllDivision() {
        return this.divisionRepository.findAll();
    }
}
