package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    List<String> itemsBought(String username) {
    	return List.of("1", "2");
    }

}
