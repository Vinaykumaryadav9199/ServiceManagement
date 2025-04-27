package com.Abc.ServiceManagement.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abc.ServiceManagement.Repo.ServiceCategoryRepository;
import com.Abc.ServiceManagement.Dto.*;


@Service
public class CategoryService {

    @Autowired
    private ServiceCategoryRepository categoryRepository;

    public List<ServiceCategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(category ->
                new ServiceCategoryDTO(
                        category.getId(),
                        category.getName(),
                        new ArrayList<>()) // Return an empty list for subcategories
        ).collect(Collectors.toList());
    }

    public ServiceCategoryDTO getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> new ServiceCategoryDTO(
                        category.getId(),
                        category.getName(),
                        new ArrayList<>())) // Return an empty list for subcategories
                .orElse(null);
    }

  
}
