package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIpml implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) throws Exception {
        Customer target=this.customerRepository.findById(id).orElse(null);
        if(target==null){
            throw new   Exception("Nobody can find");
        }
        return target;
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);

    }

    @Override
    public void remove(Long id) {
        this.customerRepository.deleteById(id);

    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllByNameContaining(Pageable pageable, String name) {
        return this.customerRepository.findAllByFirstNameContaining(pageable,name);
    }


}
