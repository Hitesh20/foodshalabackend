package com.project.foodShala.controller;


import com.project.foodShala.dao.Customer;
import com.project.foodShala.dao.MenuItem;
import com.project.foodShala.dao.Restaurant;
import com.project.foodShala.dao.ViewOrder;
import com.project.foodShala.service.CustomerService;
import com.project.foodShala.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://angularfoodshala.web.app", allowedHeaders = "*")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/addRestaurant")
    public Restaurant addCustomer(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaraunt(restaurant);
    }


    @GetMapping(value = "/getAllRestaurants")
    public List<Restaurant> getAllRestaurants() {
        // System.out.println("here");
        return restaurantService.getAllRestaraunts();
    }



    @GetMapping(path = "/validateRestaurantLogin", produces = "application/json")
    public String validateRestaurantLogin() { return "\"validRestaurant\""; }

    @GetMapping(value = "/getRole/{username}")
    public String getRole(@PathVariable String username) {
        String role = "\"restaurant\"";
        String temp;
        try {
            temp = restaurantService.getRole(username);
        } catch (Exception e) {
            temp = customerService.getRole(username);
            role = "\"customer\"";
        }
        return role;
    }

    @GetMapping(path = "/getMyOrders")
    public ArrayList<ArrayList<ViewOrder>> getMyOrders(Principal principal) {
        return restaurantService.getMyOrders(restaurantService.getId(principal));
    }







}
