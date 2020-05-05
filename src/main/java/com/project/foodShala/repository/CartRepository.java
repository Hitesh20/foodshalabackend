package com.project.foodShala.repository;

import com.project.foodShala.dao.Cart;
import com.project.foodShala.dao.Customer;
import com.project.foodShala.dao.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Object findByCustomerAndMenuItem(Customer customer, MenuItem menuItem);

    List<Cart> findByCustomer(Customer customer);

    String deleteAllByCustomerAndMenuItem(Customer customer, MenuItem menuItem);

    List<Cart> findAllByCustomer(Customer customer);
}
