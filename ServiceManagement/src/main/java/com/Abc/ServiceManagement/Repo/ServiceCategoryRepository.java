package com.Abc.ServiceManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Abc.ServiceManagement.Entity.ServiceCategoryEntity;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategoryEntity, Integer> {
    // You can add custom query methods if needed, e.g.:
    // List<ServiceCategory> findByNameContaining(String name);
}