package com.Abc.ServiceManagement.Service;

import com.Abc.ServiceManagement.Dto.*;
import com.Abc.ServiceManagement.Entity.UserEntity;
import com.Abc.ServiceManagement.Repo.UserRepository;
import com.Abc.ServiceManagement.Exception.ApiResponse;
import com.Abc.ServiceManagement.Exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpSession;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public ResponseEntity<?> register(RegisterRequestDto request) {
        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Email is already in use.", 400));
        }

        // Check if mobile already exists
        if (userRepository.existsByMobile(request.getMobile())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Mobile number is already in use.", 400));
        }

        // Create a new user entity
        System.out.println(generateUserId());
        UserEntity newUser = new UserEntity(
        	generateUserId(),
            request.getName(),
            request.getEmail(),
            request.getMobile(),
            request.getAddress(),
            request.getPassword() // For simplicity, storing the raw password, you should hash it in production
        );

       UserEntity saveUser = userRepository.save(newUser);
        

        // Return successful registration response
       UserResponseDto responceBody =  new UserResponseDto(saveUser.getUserId() , saveUser.getName(),saveUser.getEmail(),saveUser.getMobile(),saveUser.getAddress());
       
        return ResponseEntity.status(HttpStatus.CREATED).body(responceBody);
    }

    // Login user
    public ResponseEntity<?> login(LoginRequestDto request, HttpSession session) {
        // Try to find the user by email or user ID
        UserEntity user = userRepository.findByEmail(request.getEmailOrUserId())
                .orElseGet(() -> userRepository.findByUserId(request.getEmailOrUserId()).orElse(null));

        // Check if user exists and password matches
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Invalid credentials.", 401));
        }

        // Set session attributes for the logged-in user
       
       

        // Return successful login response
        UserResponseDto response = new UserResponseDto();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMobile(user.getMobile());
        response.setAddress(user.getAddress());
        session.setAttribute("user",response );
        return ResponseEntity.ok(response);
    }

    // Logout user
    public ResponseEntity<?> logout(HttpSession session) {
        // Invalidate the session to log out the user
        session.invalidate();
        return ResponseEntity.ok(new ApiResponse("Logout Succesfully", 200));
    }
    
    
    public String generateUserId() {
        Integer maxId = userRepository.findMaxAutoId(); // Get max auto-increment ID
        int nextId = (maxId == null) ? 1 : maxId + 1;
        return String.format("CUST_%05d", nextId); // Return like CUST_00001
    }



}
