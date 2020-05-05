package com.project.foodShala.service;

import com.project.foodShala.dao.Restaurant;
import com.project.foodShala.dao.ViewOrder;
import com.project.foodShala.repository.RestaurantRepository;
import com.project.foodShala.repository.ViewOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ViewOrderRepository viewOrderRepository;


    public Restaurant addRestaraunt(Restaurant restaurant) {
         return restaurantRepository.save(restaurant);
    }


//    public Long getRestaurantId(Principal principal) {
//        String email = principal.getName();
//        return restaurantRepository.();
//    }

    public String getRole(String username) {
        Restaurant restaurant = restaurantRepository.findByEmail(username);
        return restaurant.getRole();
    }

    public Long getId(Principal principal) {
        Restaurant restaurant = restaurantRepository.findByEmail(principal.getName());
        return restaurant.getRestaurantId();
    }

    public List<Restaurant> getAllRestaraunts() {
        System.out.println("coming here");
        return restaurantRepository.findAll();
    }

    public ArrayList<ArrayList<ViewOrder>> getMyOrders(Long id) {

        Restaurant restaurant = restaurantRepository.findByRestaurantId(id);
        // System.out.println(restaurant.getRestaurantName());
        ArrayList<ViewOrder> viewOrderList = viewOrderRepository.findAllByRestaurant(restaurant);
        ArrayList<ArrayList<ViewOrder>> list = new ArrayList<>();
        for(int i=0; i<viewOrderList.size(); i++) {
            ArrayList<ViewOrder> tempList = new ArrayList<>();
            Date date = viewOrderList.get(i).getDate();
            while(i<viewOrderList.size() &&viewOrderList.get(i).getDate().equals(date)) {
                tempList.add(viewOrderList.get(i));
                i++;
            }
            list.add(tempList);
            i--;
        }
        return list;
    }
}
