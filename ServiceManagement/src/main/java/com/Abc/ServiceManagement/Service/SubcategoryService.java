package com.Abc.ServiceManagement.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abc.ServiceManagement.Repo.*;
import com.Abc.ServiceManagement.Dto.*;


@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private ServiceCategoryRepository categoryRepository;

    public List<SubcategoryDTO> getAllSubcategories() {
        return subcategoryRepository.findAll().stream()
                .map(sub -> new SubcategoryDTO(sub.getId(), sub.getName(), sub.getPrice()))
                .collect(Collectors.toList());
    }

    public SubcategoryDTO getSubcategoryById(int subcategoryId) {
        return subcategoryRepository.findById(subcategoryId)
                .map(sub -> new SubcategoryDTO(sub.getId(), sub.getName(), sub.getPrice()))
                .orElse(null);
    }

    public List<SubcategoryDTO> getSubcategoriesByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> category.getSubcategories().stream()
                        .map(sub -> new SubcategoryDTO(sub.getId(), sub.getName(), sub.getPrice()))
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public List<VendorDTO> getVendorsBySubcategoryId(int subcategoryId) {
        return subcategoryRepository.findById(subcategoryId)
                .map(sub -> sub.getVendors().stream()
                        .map(vendor -> new VendorDTO(vendor.getId(), vendor.getName()))
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
    
}

