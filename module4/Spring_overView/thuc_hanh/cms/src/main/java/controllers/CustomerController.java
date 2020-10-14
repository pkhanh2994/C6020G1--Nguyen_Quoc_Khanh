package controllers;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.CustomerService;

import service.impl.SimpleCustomerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
@Autowired
CustomerService customerService;
@GetMapping("/")
    public String showList(HttpServletRequest request) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "list";
    }

}
