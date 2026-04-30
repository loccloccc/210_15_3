package org.example.bai3.controller;

import org.example.bai3.model.Order;
import org.example.bai3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(
            @RequestParam Long userId,
            @RequestParam Double totalAmount
    ) {
        return orderService.createOrder(userId, totalAmount);
    }
}
