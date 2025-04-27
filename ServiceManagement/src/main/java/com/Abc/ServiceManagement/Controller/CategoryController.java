package com.Abc.ServiceManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Abc.ServiceManagement.Service.CategoryService;
import com.Abc.ServiceManagement.Dto.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories with subcategories
    @GetMapping
    public ResponseEntity<List<ServiceCategoryDTO>> getAllCategories() {
        List<ServiceCategoryDTO> categories = categoryService.getAllCategories();
        return categories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categories);
    }

    // Get category by ID
    @GetMapping("/{categoryId}")
    public ResponseEntity<ServiceCategoryDTO> getCategoryById(@PathVariable int categoryId) {
        ServiceCategoryDTO category = categoryService.getCategoryById(categoryId);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

   
}