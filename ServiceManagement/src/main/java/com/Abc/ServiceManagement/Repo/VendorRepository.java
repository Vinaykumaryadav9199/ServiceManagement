package com.Abc.ServiceManagement.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Abc.ServiceManagement.Entity.SubcategoryEntity;
import com.Abc.ServiceManagement.Entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
    List<VendorEntity> findBySubcategory(SubcategoryEntity subcategory);
}
