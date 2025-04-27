package com.Abc.ServiceManagement.Repo;
import com.Abc.ServiceManagement.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
    // Find user by userId
    Optional<UserEntity> findByUserId(String userId);

    // Check if email already exists
    boolean existsByEmail(String email);

    // Check if mobile already exists
    boolean existsByMobile(String mobile);

    // Optional: Login by email
    Optional<UserEntity> findByEmail(String email);
    
    @Query("SELECT MAX(u.id) FROM UserEntity u")
    Integer findMaxAutoId();





}
