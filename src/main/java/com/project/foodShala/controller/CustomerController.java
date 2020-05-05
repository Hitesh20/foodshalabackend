package com.project.foodShala.controller;


import com.project.foodShala.dao.Customer;
import com.project.foodShala.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://angularfoodshala.web.app", allowedHeaders = "*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping(path = "/validateCustomerLogin", produces = "application/json")
    public String validateCustomerLogin() { return "\"validCustomer\""; }



}
