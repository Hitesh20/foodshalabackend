package com.project.foodShala.controller;

import com.project.foodShala.dao.Cart;
import com.project.foodShala.service.CartService;
import com.project.foodShala.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://angularfoodshala.web.app", allowedHeaders = "*")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable("productId") Long productId, Principal principal) {
        cartService.addProduct(customerService.getCustomerId(principal), productId);
        return "\"Added Product To Cart\"";
    }

    @GetMapping("/removeOneFromCart/{productId}")
    public String removeOneFromCart(@PathVariable("productId") Long productId, Principal principal) {
        cartService.subtractProduct(customerService.getCustomerId(principal), productId);
        return "\"Removed One Product\"";
    }

    @GetMapping("/removeFromCart/{productId}")
    public String removeFromCart(@PathVariable("productId") Long productId, Principal principal) {
        cartService.removeProduct(customerService.getCustomerId(principal), productId);
        return "\"Product Removed\"";
    }

    @GetMapping("/showCart")
    public List<Cart> showCart(Principal principal) {
        return cartService.showCustomerCart(customerService.getCustomerId(principal));
    }

    @GetMapping("/checkout")
    public void checkOutFromCart(Principal principal) {
        // cartService.generateOrderId(customerService.getCustomerId(principal));
        cartService.checkout(customerService.getCustomerId(principal));

    }
}
