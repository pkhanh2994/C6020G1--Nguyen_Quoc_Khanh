package com.codegym.service.serviceFurama;

import com.codegym.entity.service.TypeOfService;
import com.codegym.repository.service.TypeOfServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfServiceServiceImpl implements TypeOfServiceService{
    @Autowired
    TypeOfServiceRepository typeOfServiceRepository;
    @Override
    public List<TypeOfService> findAllTypeOfService() {
        return this.typeOfServiceRepository.findAll();
    }
}
