package com.example.Application1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Application1.entity.Category;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category getCategoryByID(Long categoryID);
}
