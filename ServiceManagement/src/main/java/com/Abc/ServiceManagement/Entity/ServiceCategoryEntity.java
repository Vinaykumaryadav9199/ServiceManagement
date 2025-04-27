package com.Abc.ServiceManagement.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class ServiceCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "serviceCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubcategoryEntity> subcategories;

    public ServiceCategoryEntity() {}

    public ServiceCategoryEntity(String name) {
        this.name = name;
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

    public List<SubcategoryEntity> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryEntity> subcategories) {
        this.subcategories = subcategories;
    }
}
