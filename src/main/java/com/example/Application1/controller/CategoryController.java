package com.example.Application1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Application1.entity.Category;
import com.example.Application1.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService; 
    
    @PostMapping("/addCategory")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category); 
        return ResponseEntity.status(201).body(createdCategory);
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.status(200).body(categories);
    }
    
}
