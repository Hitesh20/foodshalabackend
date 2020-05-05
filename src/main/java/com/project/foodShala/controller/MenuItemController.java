package com.project.foodShala.controller;


import com.project.foodShala.dao.MenuItem;
import com.project.foodShala.dao.Restaurant;
import com.project.foodShala.service.MenuItemService;
import com.project.foodShala.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin(origins = "https://angularfoodshala.web.app", allowedHeaders = "*")
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    @Autowired
    RestaurantService restaurantService;

//    @GetMapping(path = "/getMyMenu")
//    public List<MenuItem> validateRestaurantLogin() {
//        return new LinkedList();
//    }

    @PostMapping(value = "/addMenuItem")
    public void addMenuItem(@RequestBody MenuItem item, Principal principal) {
        menuItemService.addItemToMenu(item, restaurantService.getId(principal));
    }

    @GetMapping(value = "/getAllFoodItems")
    public List<MenuItem> getAllMenuItem() {
        // System.out.println("here");
        return menuItemService.getAllFoodItems();
    }



    @GetMapping(value = "/getAllFoodItemsOfRestaurants/{restaurantId}")
    public List<MenuItem> getAllMenuItemsOfRestaurant(@PathVariable Long restaurantId) {
        return menuItemService.getAllFoodItemsOfRestaurant(restaurantId);
    }

    @GetMapping(value = "/getMyRestaurantsFood")
    public List<MenuItem> getMyRestaurantsFood(Principal principal) {
        return menuItemService.getMyFood(restaurantService.getId(principal));
    }
}
