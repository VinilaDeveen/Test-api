package com.example.Application1.service;

import org.springframework.stereotype.Service;
import com.example.Application1.entity.Product;

import java.util.List;

@Service
public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productID);
    Product updateProduct(Product product, Long productID);

}
