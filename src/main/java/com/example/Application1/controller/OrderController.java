package com.example.Application1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.Application1.dto.OrderDto;
import com.example.Application1.entity.Order;
import com.example.Application1.entity.Product;
import com.example.Application1.service.OrderService;
import com.example.Application1.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders () {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();

        order.setTotalPrice(0.0);

        List<Long> productIds = orderDto.getOrderIds();

        List<Product> orderedProducts = new ArrayList<>();
        productIds.forEach(productId ->{
            Product product = productService.getProductById(productId);

            if (productId != null) {
                orderedProducts.add(product);

                order.setTotalPrice(order.getTotalPrice() + product.getPrice());
            }

        });

        order.setOrderedProducts(orderedProducts);

        orderService.createOrder(order);

        return ResponseEntity.status(201).body(order);
    }
    
    
}
