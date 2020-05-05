package com.project.foodShala.repository;

import com.project.foodShala.dao.Restaurant;
import com.project.foodShala.dao.ViewOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface ViewOrderRepository extends JpaRepository<ViewOrder, Long> {

    ArrayList<ViewOrder> findAllByRestaurant(Restaurant restaurant);
}
