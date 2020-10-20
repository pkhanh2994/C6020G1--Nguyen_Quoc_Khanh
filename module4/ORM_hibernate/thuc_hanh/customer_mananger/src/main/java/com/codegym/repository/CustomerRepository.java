package com.codegym.repository;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer>findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id);
    void update(Customer customer);

}
