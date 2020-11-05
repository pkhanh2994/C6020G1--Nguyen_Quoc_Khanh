package com.codegym.service.customer;

import com.codegym.entity.customer.TypeOfCustomer;
import com.codegym.repository.customer.TypeOfCustomerRepository;
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
