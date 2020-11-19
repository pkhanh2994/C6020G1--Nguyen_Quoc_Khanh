package com.codgym.service;

import com.codgym.entity.Customer;
import com.codgym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByNameCustomer(Pageable pageable, String customerName) {
        return this.customerRepository.findAllByNameCustomer(pageable,customerName);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }


    @Override
    public void deleteCustomerById(String idCustomer) {
        this.customerRepository.deleteById(idCustomer);

    }

    @Override
    public Customer findCustomerById(String customerId) {
        return this.customerRepository.findById(customerId).orElse(null);
    }


}
