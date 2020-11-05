package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.repository.customer.CustomerRepository;
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
    public Page<Customer> findAllByNameCustomer(Pageable pageable, java.lang.String customerName) {
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
