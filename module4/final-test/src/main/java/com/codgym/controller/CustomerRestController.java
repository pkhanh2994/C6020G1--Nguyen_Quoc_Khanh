package com.codgym.controller;

import com.codgym.entity.Customer;
import com.codgym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/findOne")
    public Customer findCustomerByID(@RequestParam("id") String id) {
        Customer customer= new Customer();
        Customer tmp = this.customerService.findCustomerById(id);

        //init
        customer.setCustomer_id(tmp.getCustomer_id());
        customer.setCustomer_name(tmp.getCustomer_name());
        customer.setCustomer_birthday(tmp.getCustomer_birthday());
        customer.setCustomer_gender(tmp.getCustomer_gender());
        customer.setCustomer_id_card(tmp.getCustomer_id_card());
        customer.setCustomer_phone(tmp.getCustomer_phone());
        customer.setCustomer_email(tmp.getCustomer_email());
        customer.setCustomer_address(tmp.getCustomer_address());

        return customer;
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validatePost(@Validated @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> fieldErrorList = new ArrayList<>();
            fieldErrorList.add(bindingResult.getFieldError("customer_id"));
            fieldErrorList.add(bindingResult.getFieldError("customer_id_card"));
            fieldErrorList.add(bindingResult.getFieldError("customer_phone"));
            fieldErrorList.add(bindingResult.getFieldError("customer_email"));
            return new ResponseEntity<>(fieldErrorList, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            this.customerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
