package com.project.foodShala.dao;
import javax.persistence.*;
import java.util.Date;

@Entity
public class ViewOrder {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    @ManyToOne
    MenuItem item;
    Date date;
    int quantity;
    @ManyToOne
    Customer customer;
    @ManyToOne
    Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
