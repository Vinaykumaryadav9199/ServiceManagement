package com.Abc.ServiceManagement.Dto;

import java.util.List;

public class SubcategoryDTO {
    private int id;
    private String name;
    private int price;
    private List<VendorDTO> vendors;

    public SubcategoryDTO(int id, String name, int price, List<VendorDTO> vendors) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vendors = vendors;
    }

    
	public SubcategoryDTO(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<VendorDTO> getVendors() {
		return vendors;
	}

	public void setVendors(List<VendorDTO> vendors) {
		this.vendors = vendors;
	}

    // Getters & Setters
}