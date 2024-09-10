package com.example.Application1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Application1.dto.ProductReqDto;
import com.example.Application1.entity.Category;
import com.example.Application1.entity.Product;
import com.example.Application1.service.CategoryService;
import com.example.Application1.service.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct (@RequestBody ProductReqDto productReqDto) {
        Product product = new Product();
        product.setName(productReqDto.getName());
        product.setPrice(productReqDto.getPrice());
        product.setDescription(productReqDto.getDescription());
        
        Category category = categoryService.getCategoryByID(productReqDto.getCategoryID());
        product.setCategory(category);

        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> products = productService.getAllProducts(); 
        return ResponseEntity.status(200).body(products);
    }

    @PutMapping("/updateProduct/{productID}")
    public ResponseEntity<Product> updateProduct (@PathVariable Long productID, @RequestBody ProductReqDto productReqDto) {
        Product product = new Product();
        product.setName(productReqDto.getName());
        product.setPrice(productReqDto.getPrice());
        product.setDescription(productReqDto.getDescription());

        Category category = categoryService.getCategoryByID(productReqDto.getCategoryID());
        product.setCategory(category);

        Product updatedProduct = productService.updateProduct(product, productID);
        return ResponseEntity.status(200).body(updatedProduct);
    }
    
}
