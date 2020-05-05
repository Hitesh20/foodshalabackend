package com.project.foodShala.service;


import com.project.foodShala.dao.MenuItem;
import com.project.foodShala.dao.Restaurant;
import com.project.foodShala.repository.MenuItemRepository;
import com.project.foodShala.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    RestaurantRepository restaurantRepository;


    public void addItemToMenu(MenuItem item, Long id) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(id);
        item.setRestaurant(restaurant);
        menuItemRepository.save(item);
    }

    public List<MenuItem> getAllFoodItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> getAllFoodItemsOfRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        return menuItemRepository.findByRestaurant(restaurant);
    }

    public List<MenuItem> getMyFood(Long id) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(id);
        return menuItemRepository.findByRestaurant(restaurant);
    }
}
