package com.codegym.service.employee;

import com.codegym.entity.employee.Position;
import com.codegym.repository.employee.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAllPosition() {
        return this.positionRepository.findAll();
    }
}
