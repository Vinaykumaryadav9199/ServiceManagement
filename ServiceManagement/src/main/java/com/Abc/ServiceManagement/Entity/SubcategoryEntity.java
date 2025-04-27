package com.Abc.ServiceManagement.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "subcategory")
public class SubcategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_category_id", nullable = false)
    private ServiceCategoryEntity serviceCategory;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendorEntity> vendors;

    public SubcategoryEntity() {}

    public SubcategoryEntity(String name, int price, ServiceCategoryEntity serviceCategory) {
        this.name = name;
        this.price = price;
        this.serviceCategory = serviceCategory;
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

    public ServiceCategoryEntity getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategoryEntity serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public List<VendorEntity> getVendors() {
        return vendors;
    }

    public void setVendors(List<VendorEntity> vendors) {
        this.vendors = vendors;
    }
}
