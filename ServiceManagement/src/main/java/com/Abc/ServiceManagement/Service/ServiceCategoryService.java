package com.Abc.ServiceManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Abc.ServiceManagement.Dto.ServiceCategoryDTO;
import com.Abc.ServiceManagement.Dto.SubcategoryDTO;
import com.Abc.ServiceManagement.Dto.VendorDTO;
import com.Abc.ServiceManagement.Repo.ServiceCategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCategoryService {

    @Autowired
    private ServiceCategoryRepository categoryRepository;

    public List<ServiceCategoryDTO> getAllCategoriesWithSubcategoriesAndVendors() {
        return categoryRepository.findAll().stream().map(category -> {
            List<SubcategoryDTO> subcategoryDTOs = category.getSubcategories().stream().map(subcat -> {
                List<VendorDTO> vendorDTOs = subcat.getVendors().stream()
                        .map(vendor -> new VendorDTO(vendor.getId(), vendor.getName()))
                        .collect(Collectors.toList());

                return new SubcategoryDTO(subcat.getId(), subcat.getName(), subcat.getPrice(), vendorDTOs);
            }).collect(Collectors.toList());

            return new ServiceCategoryDTO(category.getId(), category.getName(), subcategoryDTOs);
        }).collect(Collectors.toList());
    }
    
    public List<ServiceCategoryDTO> getCategoriesWithSubcategoriesOnly() {
        return categoryRepository.findAll().stream().map(category -> {
            List<SubcategoryDTO> subDTOs = category.getSubcategories().stream()
                    .map(sub -> new SubcategoryDTO(sub.getId(), sub.getName(), sub.getPrice()))
                    .collect(Collectors.toList());

            return new ServiceCategoryDTO(category.getId(), category.getName(), subDTOs);
        }).collect(Collectors.toList());
    }
}