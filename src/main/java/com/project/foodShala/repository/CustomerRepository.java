package com.project.foodShala.repository;

import com.project.foodShala.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String username);
    Customer findByCustomerId(Long id);
}
