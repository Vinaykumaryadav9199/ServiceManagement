package com.Abc.ServiceManagement.Dto;

import java.util.List;

public class ServiceCategoryDTO {
    private int id;
    private String name;
    private List<SubcategoryDTO> subcategories;

    public ServiceCategoryDTO(int id, String name, List<SubcategoryDTO> subcategories) {
        this.id = id;
        this.name = name;
        this.subcategories = subcategories;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubcategoryDTO> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<SubcategoryDTO> subcategories) {
		this.subcategories = subcategories;
	}

    // Getters & Setters
}
