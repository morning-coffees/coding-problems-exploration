package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private OrdersService ordersService;

    UsersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public int getNumberOfItemsBought(String username) {
        return ordersService.itemsBought(username).size();
    }
}
