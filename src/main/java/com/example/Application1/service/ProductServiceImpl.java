package com.example.Application1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Application1.entity.Product;
import com.example.Application1.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(Product product, Long productID) {
        Product existingProduct = productRepo.findById(productID).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(product.getCategory());
            
            return productRepo.save(existingProduct);
        }

        return null;
    }

    @Override
    public Product getProductById(Long productID) {
        return productRepo.findById(productID).orElse(null);
    }
 
}
