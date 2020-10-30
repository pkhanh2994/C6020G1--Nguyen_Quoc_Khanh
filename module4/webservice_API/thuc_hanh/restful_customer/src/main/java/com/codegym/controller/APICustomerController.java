package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/customerRest")
public class APICustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(this.customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Customer>customerDetail(@PathVariable Long id){
        return new ResponseEntity<>(this.customerService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer,@PathVariable Long id){
        Customer customerCurrent=this.customerService.findById(id);
        if(customerCurrent ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            customerCurrent.setFirstName(customer.getFirstName());
            customerCurrent.setLastName(customer.getLastName());
            customerCurrent.setId(customer.getId());
        this.customerService.save(customerCurrent);
            return new ResponseEntity<Customer>(customerCurrent,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteCustomer(@PathVariable Long id){
        this.customerService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        this.customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customerRest/detail/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus .CREATED);
    }
}
