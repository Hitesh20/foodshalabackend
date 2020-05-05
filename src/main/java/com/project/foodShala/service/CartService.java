package com.project.foodShala.service;



import com.project.foodShala.dao.*;
import com.project.foodShala.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class CartService {

    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ViewOrderRepository viewOrderRepository;



    public void addProduct(Long user_id, Long product_id) {

        MenuItem menuItem = menuItemRepository.findByFoodId(product_id);

        Customer customer = customerRepository.findByCustomerId(user_id);

        if(cartRepository.findByCustomerAndMenuItem(customer, menuItem)!=null) {

            Cart cart = (Cart) cartRepository.findByCustomerAndMenuItem(customer, menuItem);
            cart.setQuantity(cart.getQuantity()+1);
            cartRepository.save(cart);
        } else {
            Cart cart = new Cart(menuItem, customer, 1);
            cartRepository.save(cart);
        }

        /*return cartRepository.findByUsersAndProducts(users, products);*/
    }


    public void removeProduct(Long userId, Long productId) {
        MenuItem products = menuItemRepository.findByFoodId(productId);
        Customer users = customerRepository.findByCustomerId(userId);
        cartRepository.deleteAllByCustomerAndMenuItem(users, products);
        /*return "removed";*/
    }

    public List<Cart> showCustomerCart(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        // System.out.println(customer.getName());
        return cartRepository.findByCustomer(customer);
    }



    public void subtractProduct(Long userId, Long productId) {

        MenuItem products = menuItemRepository.findByFoodId(productId);

        Customer users = customerRepository.findByCustomerId(userId);

        if(cartRepository.findByCustomerAndMenuItem(users, products)!=null) {

            Cart cart = (Cart) cartRepository.findByCustomerAndMenuItem(users, products);
            if(cart.getQuantity()>=2) {
                cart.setQuantity(cart.getQuantity() - 1);
                cartRepository.save(cart);
            } else if(cart.getQuantity()==1) {
                removeProduct(userId, productId);
            }
        }
        /*return (Cart) cartRepository.findByUsersAndProducts(users, products);*/

    }

    public void checkout(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);

        List<Cart> list = (ArrayList)cartRepository.findAllByCustomer(customer);
        Date date = new Date();
        for(Cart cart: list) {
            ViewOrder order = new ViewOrder();
            order.setCustomer(customer);
            order.setDate(date);
            order.setItem(cart.getMenuItem());
            order.setQuantity(cart.getQuantity());
            order.setRestaurant(cart.getMenuItem().getRestaurant());
            cartRepository.delete(cart);
            viewOrderRepository.save(order);
        }

    }

}
