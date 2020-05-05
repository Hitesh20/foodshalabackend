package com.project.foodShala.repository;

import com.project.foodShala.dao.Customer;
import com.project.foodShala.dao.MenuItem;
import com.project.foodShala.dao.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByRestaurant(Restaurant restaurant);
    MenuItem findByFoodId(Long id);
}
