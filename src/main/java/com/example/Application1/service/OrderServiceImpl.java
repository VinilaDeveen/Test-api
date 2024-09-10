package com.example.Application1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Application1.entity.Order;
import com.example.Application1.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    
}
