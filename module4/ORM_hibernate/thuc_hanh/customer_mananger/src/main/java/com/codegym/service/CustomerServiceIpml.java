package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceIpml implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);

    }

    @Override
    public void remove(Long id) {
        this.customerRepository.remove(id);

    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.update(customer);
    }
}
