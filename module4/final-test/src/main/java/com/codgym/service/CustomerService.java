package com.codgym.service;



import com.codgym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer>findAllByNameCustomer(Pageable pageable, String customerName);
    void save(Customer customer);
    void deleteCustomerById(String customerId);
    Customer findCustomerById(String customerId);


}
