package com.Abc.ServiceManagement.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Abc.ServiceManagement.Entity.BookingEntity;
import com.Abc.ServiceManagement.Entity.ServiceCategoryEntity;
import com.Abc.ServiceManagement.Entity.UserEntity;
import com.Abc.ServiceManagement.Entity.VendorEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{

	  List<BookingEntity> findByUser_UserId(String userId);

}
