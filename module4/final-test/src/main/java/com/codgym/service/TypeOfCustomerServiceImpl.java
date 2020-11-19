package com.codgym.service;


import com.codgym.entity.TypeOfCustomer;
import com.codgym.repository.TypeOfCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfCustomerServiceImpl implements TypeOfCustomerService{
    @Autowired
    private TypeOfCustomerRepository typeOfCustomerRepository;
    @Override
    public List<TypeOfCustomer> findAllTypeOfCustomer() {
        return this.typeOfCustomerRepository.findAll();
    }
}
