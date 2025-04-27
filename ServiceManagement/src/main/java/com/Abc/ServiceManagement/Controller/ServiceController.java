package com.Abc.ServiceManagement.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Abc.ServiceManagement.Dto.ServiceCategoryDTO;
import com.Abc.ServiceManagement.Service.ServiceCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")

public class ServiceController {
	@Autowired
    private ServiceCategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<List<ServiceCategoryDTO>> getCategoriesForBooking() {
	    List<ServiceCategoryDTO> categories = categoryService.getAllCategoriesWithSubcategoriesAndVendors();

	    if (categories.isEmpty()) {
	        return ResponseEntity.noContent().build(); // 204 No Content
	    }

	    return ResponseEntity.ok(categories); // 200 OK with data
	}
	@GetMapping("/subcategories")
	public ResponseEntity<List<ServiceCategoryDTO>> getCategoriesAndSubcategories() {
	    List<ServiceCategoryDTO> categories = categoryService.getCategoriesWithSubcategoriesOnly();

	    if (categories.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }

	    return ResponseEntity.ok(categories);
	}
}
