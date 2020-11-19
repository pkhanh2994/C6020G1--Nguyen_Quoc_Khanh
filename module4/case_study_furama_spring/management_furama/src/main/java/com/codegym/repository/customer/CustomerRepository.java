package com.codegym.repository.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query(value = "select * from customer where concat(customer_name,'',customer_address,'')   like %?1%", nativeQuery = true)
    Page<Customer>findAllByNameCustomer(Pageable pageable,String customerName);
}
