package com.project.foodShala.repository;

import com.project.foodShala.dao.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByEmail(String name);

    Restaurant findByRestaurantId(Long id);

}
