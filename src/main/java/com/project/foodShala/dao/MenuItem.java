package com.project.foodShala.dao;


import javax.persistence.*;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long foodId;
    private String foodItem;
    private String foodType;
    private float price;
    @ManyToOne
    private Restaurant restaurant;

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getType() {
        return foodType;
    }

    public void setType(String foodType) {
        this.foodType = foodType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
