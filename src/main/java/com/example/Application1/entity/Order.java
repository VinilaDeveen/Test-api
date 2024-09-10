package com.example.Application1.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    private LocalDateTime orderDateTime;
    
    private Double totalPrice;

    @PrePersist //execute before the entity is created
    protected void create(){
        this.orderDateTime.now();
    }

    @ManyToMany
    @JoinTable(
        name = "oreder_product",
        joinColumns = @JoinColumn(name = "orderID"),
        inverseJoinColumns = @JoinColumn(name = "productID")
    )
    private List<Product> orderedProducts;
}
