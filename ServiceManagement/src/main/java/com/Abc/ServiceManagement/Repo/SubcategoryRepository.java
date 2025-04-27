package com.Abc.ServiceManagement.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Abc.ServiceManagement.Entity.ServiceCategoryEntity;
import com.Abc.ServiceManagement.Entity.SubcategoryEntity;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {
    List<SubcategoryEntity> findByServiceCategory(ServiceCategoryEntity serviceCategory);
}
