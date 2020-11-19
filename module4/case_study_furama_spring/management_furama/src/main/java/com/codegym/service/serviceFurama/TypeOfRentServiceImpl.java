package com.codegym.service.serviceFurama;

import com.codegym.entity.service.TypeOfRent;
import com.codegym.repository.service.TypeOfRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeOfRentServiceImpl implements TypeOfRentService{
    @Autowired
    TypeOfRentRepository typeOfRentRepository;
    @Override
    public List<TypeOfRent> findAllTypeOfRent() {
        return this.typeOfRentRepository.findAll();
    }
}
