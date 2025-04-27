package com.Abc.ServiceManagement.Controller;

import com.Abc.ServiceManagement.Dto.*;
import com.Abc.ServiceManagement.Exception.ApiResponse;
import com.Abc.ServiceManagement.Exception.ErrorResponse;
import com.Abc.ServiceManagement.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Registration endpoint
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequest) {
        return authService.register(registerRequest);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest, HttpSession session) {
        return authService.login(loginRequest, session);
    }

    // Logout endpoint
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        return authService.logout(session);
    }
    
    @GetMapping("/validate")
    public ResponseEntity<?> validateSession(HttpSession session) {
        // Check if the session is still valid
    	 UserResponseDto userResponse = (UserResponseDto) session.getAttribute("user");
        if (userResponse != null) {
            return ResponseEntity.ok(new ApiResponse("Session Valideted", 200));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Session expired", 401));
        }
    }
}
