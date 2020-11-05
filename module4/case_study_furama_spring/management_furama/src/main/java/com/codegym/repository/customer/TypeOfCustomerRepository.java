package com.codegym.repository.customer;

import com.codegym.entity.customer.TypeOfCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfCustomerRepository extends JpaRepository<TypeOfCustomer,String> {
}
