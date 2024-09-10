package com.example.Application1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Application1.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
}
