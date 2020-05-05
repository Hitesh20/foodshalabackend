package com.project.foodShala.service;

import com.project.foodShala.dao.Customer;
import com.project.foodShala.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public String getRole(String username) {
        Customer customer = customerRepository.findByEmail(username);
        return customer.getRole();
    }

    public Long getCustomerId(Principal principal) {
        String email = principal.getName();
        Customer customer = customerRepository.findByEmail(email);
        Long id = customer.getCustomerId();
        return id;
    }
}
