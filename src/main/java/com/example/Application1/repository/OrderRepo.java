package com.example.Application1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Application1.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
    
}
