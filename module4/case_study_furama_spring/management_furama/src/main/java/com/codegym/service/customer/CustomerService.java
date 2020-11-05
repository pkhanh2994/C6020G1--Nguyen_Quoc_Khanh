package com.codegym.service.customer;


import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer>findAllByNameCustomer(Pageable pageable,String customerName);
    void save(Customer customer);
    void deleteCustomerById(String customerId);
    Customer findCustomerById(String customerId);


}
