package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id) throws Exception;
    void save(Customer customer);
    void remove(Long id);
    void update(Customer customer);
    Page<Customer>findAllByNameContaining(Pageable pageable, String name);

}
