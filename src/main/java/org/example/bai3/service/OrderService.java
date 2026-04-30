package org.example.bai3.service;

import org.example.bai3.model.Order;
import org.example.bai3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private     OrderRepository orderRepository;

    public Order createOrder(Long userId, Double totalAmount) {

        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("UserId không hợp lệ");
        }

        if (totalAmount == null || totalAmount <= 0) {
            throw new IllegalArgumentException("Tổng tiền không hợp lệ");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING");
        order.setCreatedDate(LocalDateTime.now());

        return orderRepository.save(order);
    }
}
