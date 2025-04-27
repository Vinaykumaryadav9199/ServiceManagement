package com.Abc.ServiceManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Abc.ServiceManagement.Service.SubcategoryService;
import com.Abc.ServiceManagement.Dto.*;

@RestController
@RequestMapping("/api/v1/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    // Get all subcategories
    @GetMapping
    public ResponseEntity<List<SubcategoryDTO>> getAllSubcategories() {
        List<SubcategoryDTO> subcategories = subcategoryService.getAllSubcategories();
        return subcategories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(subcategories);
    }

    // Get subcategory by ID
    @GetMapping("/{subcategoryId}")
    public ResponseEntity<SubcategoryDTO> getSubcategoryById(@PathVariable int subcategoryId) {
        SubcategoryDTO subcategory = subcategoryService.getSubcategoryById(subcategoryId);
        return subcategory != null ? ResponseEntity.ok(subcategory) : ResponseEntity.notFound().build();
    }

    // Get vendors under subcategory
    @GetMapping("/{subcategoryId}/vendors")
    public ResponseEntity<List<VendorDTO>> getVendorsBySubcategoryId(@PathVariable int subcategoryId) {
        List<VendorDTO> vendors = subcategoryService.getVendorsBySubcategoryId(subcategoryId);
        return vendors.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(vendors);
    }
}
